package com.atguigu.aop;

import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Test
    public void test() {
        CalculatorLog calculatorLog = (a, b) -> a + b + 999;
        var factory = new ProxyFactory<>(calculatorLog);
        CalculatorLog proxy = (CalculatorLog) factory.getProxy();
        proxy.add(1, 0);
    }
}

interface CalculatorLog {
    int add(int a, int b);
}