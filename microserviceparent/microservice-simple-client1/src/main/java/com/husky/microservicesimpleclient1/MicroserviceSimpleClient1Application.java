package com.husky.microservicesimpleclient1;

import com.husky.microservicesimpleclient1.pojo.UserInfo;
import com.husky.microservicesimpleclient1.service.UserInfoService;
import com.husky.microservicesimpleclient1.service.imp.UserInfoServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class MicroserviceSimpleClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleClient1Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTamplate(){
        return new RestTemplate();
    }
}
