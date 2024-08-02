package com.atguigu.resource_test.provider;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceProvider {
    // 项目根目录下

    @Bean
    public Resource getResource() {
        return new ClassPathResource("atguigu.txt");
    }
//    public Resource res = new ClassPathResource("atguigu.txt");


}
