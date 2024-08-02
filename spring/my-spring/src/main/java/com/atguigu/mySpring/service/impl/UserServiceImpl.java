package com.atguigu.mySpring.service.impl;

import com.atguigu.mySpring.core.Bean;
import com.atguigu.mySpring.core.Di;
import com.atguigu.mySpring.dao.UserDao;
import com.atguigu.mySpring.dao.impl.UserDaoImpl;
import com.atguigu.mySpring.service.UserService;

@Bean
public class UserServiceImpl implements UserService {
    @Di
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void print() {
        userDao.print();
        System.out.println("service...");
    }
}
