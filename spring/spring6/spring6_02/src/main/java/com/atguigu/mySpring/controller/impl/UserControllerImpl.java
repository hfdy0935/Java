package com.atguigu.mySpring.controller.impl;

import com.atguigu.mySpring.controller.UserController;
import com.atguigu.mySpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControllerImpl implements UserController {
    // 1. 加到属性上，不推荐
//    @Autowired
    private UserService userService = null;

    // 2. 加到构造函数上
    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }
    // 3. 加到构造函数的形参上
//    public UserControllerImpl(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    // 4. 加到对应的set方法上
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @Override
    public void print() {
        userService.print();
        System.out.println("control...");
    }
}
