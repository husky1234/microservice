package com.husky.servercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServercenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServercenterApplication.class, args);
    }

}
