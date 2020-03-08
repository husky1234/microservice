package com.husky.microservicesimpleprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceSimpleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleProviderApplication.class, args);
    }

}
