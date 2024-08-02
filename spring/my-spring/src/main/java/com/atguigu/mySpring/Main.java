package com.atguigu.mySpring;

import com.atguigu.mySpring.control.UserControl;
import com.atguigu.mySpring.core.impl.AnnotationApplicationContextImpl;

public class Main {
    public static void main(String[] args) {
        AnnotationApplicationContextImpl context = new AnnotationApplicationContextImpl("com.atguigu.mySpring");
        UserControl userControl = context.getBean(UserControl.class);
        userControl.print();
    }


}

