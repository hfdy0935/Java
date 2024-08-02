package com.atguigu.mySpring.core.impl;

import com.atguigu.mySpring.core.AnnotationApplicationContext;
import com.atguigu.mySpring.core.Bean;
import com.atguigu.mySpring.core.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContextImpl implements AnnotationApplicationContext {
    // 存储bean的容器
    private final HashMap<Class<?>, Object> beanFactory = new HashMap<>();
    private static String rootPath;

    @Override
    public <T> T getBean(Class<T> clazz) {
        return (T) beanFactory.get(clazz);
    }

    /**
     * 根据包扫描加载bean
     *
     * @param basePackage String
     */
    public AnnotationApplicationContextImpl(String basePackage) {
        // 本质是把basepackage转成绝对路径，遍历里面所有.class文件，创建用反射实例，存进map
        try {
            // 1. 把.替换成\
            String packageDirName = basePackage.replaceAll("\\.", "\\\\");
            // 2. 获取包的绝对路径，\变成%了
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                // 把%转回\
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                // 从盘符开始，到输入的项目（不包括）结束
                rootPath = filePath.substring(0, filePath.length() - packageDirName.length());
                loadBean(beanFactory, new File(filePath));
                loadDi();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadBean(HashMap<Class<?>, Object> beanFactory, File fileParent) throws Exception {
        if (fileParent.isDirectory()) {
            File[] childrenFiles = fileParent.listFiles();
            // 如果该路径下没有文件
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            for (File child : childrenFiles) {
                // 如果子文件还是个文件夹，递归执行
                if (child.isDirectory()) {
                    loadBean(beanFactory, child);
                } else {
                    // 通过文件路径转为全类名
                    // 去掉项目目录之前的绝对路径
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    // 判断是否是.class文件
                    if (pathWithClass.endsWith(".class")) {
                        // 去掉.class后缀，把\换成.
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replaceAll(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);
                            // 把非接口的类实例化放在map中
                            if (!aClass.isInterface()) {
                                Bean annotation = aClass.getAnnotation(Bean.class);
                                // 如果有Bean注解
                                if (annotation != null) {
                                    Object instance = aClass.getDeclaredConstructor().newInstance();
                                    // 判断有没有接口
                                    if (aClass.getInterfaces().length > 0) {
                                        // 如果map中该key已有，报错
                                        if (beanFactory.containsKey(aClass.getInterfaces()[0])) {
                                            throw new Exception("该接口由>1个类实现");
                                        }
                                        //如果有接口，把接口的class当成key，实例对象当成value
                                        System.out.println("正在加载【" + aClass.getInterfaces()[0] + "】,实例对象是：" + instance.getClass().getName());
                                        beanFactory.put(aClass.getInterfaces()[0], instance);
                                    } else {
                                        //如果没有接口，把自己的class当成key，实例对象当成value
                                        System.out.println("正在加载【" + aClass.getName() + "】,实例对象是：" + instance.getClass().getName());
                                        beanFactory.put(aClass, instance);
                                    }
                                }
                            }
                        } catch (ClassNotFoundException | InstantiationError e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }

    /**
     * 依赖注入
     */
    private void loadDi() {
        for (Map.Entry<Class<?>, Object> entry : beanFactory.entrySet()) {
            Object obj = entry.getValue();
            Class<?> clazz = obj.getClass();
            // 只考虑在属性上的注解
            Field[] declareFields = clazz.getDeclaredFields();
            for (Field declaredField : declareFields) {
                Di annotation = declaredField.getAnnotation(Di.class);
                if (annotation != null) {
                    declaredField.setAccessible(true);
                    try {
                        System.out.println("正在给【" + obj.getClass().getName() + "】属性【" + declaredField.getName() + "】");
                        declaredField.set(obj, beanFactory.get((declaredField.getType())));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
