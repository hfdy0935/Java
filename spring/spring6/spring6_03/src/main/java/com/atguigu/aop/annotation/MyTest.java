package com.atguigu.aop.annotation;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    private final Logger logger = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Calculator calculator = ac.getBean(Calculator.class);
        int add = calculator.add(1, 1);
        logger.info("执行成功:" + add);
    }
}
