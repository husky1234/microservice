package com.atguigu.springboot.controller;


import com.atguigu.springboot.rule.LoadBalancer;
import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    RestTemplate restTemplate;

    @Resource
    LoadBalancer loadBalancer;

    @Resource
    DiscoveryClient discoveryClient;
    @GetMapping("/create")
    public CommentResult<PaymentEntity> create(@RequestBody PaymentEntity paymentEntity){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",paymentEntity,CommentResult.class);
    }
    @GetMapping("/get/{id}")
    public CommentResult<PaymentEntity> getById(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommentResult.class);
    }
    @GetMapping("lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(x-> System.out.println(x.getUri()));
        if (instances == null || instances.size() < 0){
            return null;
        }
        ServiceInstance instances1 = loadBalancer.instances(instances);
        URI uri = instances1.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
