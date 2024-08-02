package com.atguigu.mySpring;

import com.atguigu.mySpring.config.Spring6Config;
import com.atguigu.mySpring.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserController userController = context.getBean(UserController.class);
        userController.print();
    }
}
