package com.atguigu.mySpring.service.impl;

import com.atguigu.mySpring.dao.UserDao;
import com.atguigu.mySpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao = null;

    // 1. 加到属性上，不推荐
//    @Autowired
//    private final UserDao userDao = new UserDaoImpl();

    // 2. 加到构造函数上
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
    // 3. 加到构造函数的形参上
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 4. 加到对应的set方法上
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void print() {
        userDao.print();
        System.out.println("service...");
    }
}
