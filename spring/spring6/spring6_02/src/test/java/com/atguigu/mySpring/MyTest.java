package com.atguigu.mySpring;

import com.atguigu.mySpring.config.Spring6Config;
import com.atguigu.mySpring.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserController userController = context.getBean(UserController.class);
        userController.print();

        // 全注解开发
        ApplicationContext context2 = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserController userController2 = context2.getBean(UserController.class);
        userController2.print();
    }
}
