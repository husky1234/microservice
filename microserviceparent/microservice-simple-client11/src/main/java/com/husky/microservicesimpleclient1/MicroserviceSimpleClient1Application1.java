package com.husky.microservicesimpleclient1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MicroserviceSimpleClient1Application1 {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleClient1Application1.class, args);
    }

}
