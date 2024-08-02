package com.atguigu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory<T> {
    private T target;

    public ProxyFactory(T target) {
        this.target = target;
    }

    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = (Object proxy, Method method, Object[] args) -> {
            Object result = null;
            try {
                System.out.println("[动态代理][日志] " + method.getName() + "，参数：" + Arrays.toString(args));
                result = method.invoke(target, args);
                System.out.println("[动态代理][日志] " + method.getName() + "，结果：" + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("[动态代理][日志] " + method.getName() + "，异常：" + e.getMessage());
            } finally {
                System.out.println("[动态代理][日志] " + method.getName() + "，方法执行完毕");
            }
            return result;
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}

