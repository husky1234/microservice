package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsumerNacos {
    @Resource
    RestTemplate restTemplate;
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacos.class,args);
    }
    @GetMapping("consumer/nacos")
    public String getInfo(){
        return restTemplate.getForObject("http://nacos-provider/payment/nacos/",String.class);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
