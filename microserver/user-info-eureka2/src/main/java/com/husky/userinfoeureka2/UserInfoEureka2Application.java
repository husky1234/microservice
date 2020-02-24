package com.husky.userinfoeureka2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.husky.userinfoeureka2.mapper")
@EnableHystrix
public class UserInfoEureka2Application {

    public static void main(String[] args) {
        SpringApplication.run(UserInfoEureka2Application.class, args);
    }

}
