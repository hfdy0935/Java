package com.atguigu.resource_test;

import com.atguigu.resource_test.provider.ResourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ResourceBean {
    private Resource res;

    @Autowired
    public ResourceBean(Resource res) {
        this.res = res;
    }

    public Resource getRes() {
        return res;
    }

//    @Autowired
//    public void setRes(ResourceProvider res) {
//        this.res = res.res;
//    }

    public void parse() {
        System.out.println(res.getFilename());
        System.out.println(res.getDescription());
        System.out.println("======================================");
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(res.getInputStream()));
            String str = "";
            while ((str = bf.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
