package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.atguigu.springcloud.mapper")
@EnableEurekaClient
public class PaymentBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(PaymentBootstrap.class,args);
    }
}
