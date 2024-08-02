package com.atguigu.mySpring.dao.impl;

import com.atguigu.mySpring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void print() {
        System.out.println("dao...");
    }
}
