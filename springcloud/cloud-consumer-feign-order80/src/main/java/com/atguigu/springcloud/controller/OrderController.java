package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feign.OrderFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    @Resource
    OrderFeignClient client;
    @GetMapping("/normal/{id}")
    public String getString(@PathVariable("id") int id){
        log.info(id+"");
        return client.getMessage(id);
    }
    @GetMapping("/timeout/{id}")
    public String getTimeoutString(@PathVariable("id") int id){
        log.info(id+"");
        return client.getTimeoutMessage(id);
    }
}
