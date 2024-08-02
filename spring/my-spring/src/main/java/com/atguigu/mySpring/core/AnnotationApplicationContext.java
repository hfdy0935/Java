package com.atguigu.mySpring.core;

public interface AnnotationApplicationContext {
//    Object getBean(Class<?> clazz);

    <T> T getBean(Class<T> clazz);
}
