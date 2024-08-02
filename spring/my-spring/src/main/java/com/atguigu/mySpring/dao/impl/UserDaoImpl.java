package com.atguigu.mySpring.dao.impl;

import com.atguigu.mySpring.core.Bean;
import com.atguigu.mySpring.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void print() {
        System.out.println("dao...");
    }
}
