package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosServerMain01 {
    public static void main(String[] args) {
        SpringApplication.run(NacosServerMain01.class,args);
    }

    @GetMapping("payment/nacos")
    public String getInfo(){
        return UUID.randomUUID().toString()+"\tnacos server 9002";
    }
}
