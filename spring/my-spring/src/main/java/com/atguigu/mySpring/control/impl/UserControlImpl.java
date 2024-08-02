package com.atguigu.mySpring.control.impl;

import com.atguigu.mySpring.control.UserControl;
import com.atguigu.mySpring.core.Bean;
import com.atguigu.mySpring.core.Di;
import com.atguigu.mySpring.service.UserService;
import com.atguigu.mySpring.service.impl.UserServiceImpl;

@Bean
public class UserControlImpl implements UserControl {
    @Di
    private final UserService userService = new UserServiceImpl();

    @Override
    public void print() {
        userService.print();
        System.out.println("control...");
    }
}
