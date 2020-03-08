package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@MapperScan("com.atguigu.springcloud.mapper")
@EnableDiscoveryClient
public class PaymentBootstrap8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentBootstrap8004.class,args);
    }
}
