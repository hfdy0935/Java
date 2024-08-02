package com.atguigu.mySpring.control.impl;


import com.atguigu.mySpring.control.UserControl;

/**
 * 这个类如果也实现UserControl，该接口就由两个类实现了，会报错，符合预期
 */
//@Bean
public class AnotherUserControl implements UserControl {
    @Override
    public void print() {
    }
}
