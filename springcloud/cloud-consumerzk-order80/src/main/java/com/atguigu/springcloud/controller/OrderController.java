package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class OrderController {
    private final String URL = "http://cloud-payment-service";
    @Resource
    RestTemplate restTemplate;
    @GetMapping("/test")
    public String getString(){
        return restTemplate.getForObject(URL+"/payment/zk",String.class);
    }
}
