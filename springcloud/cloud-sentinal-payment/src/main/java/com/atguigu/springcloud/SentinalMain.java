package com.atguigu.springcloud;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@SpringBootApplication
@Slf4j
@RestController
@EnableDiscoveryClient
public class SentinalMain {
    public static void main(String[] args) {
        SpringApplication.run(SentinalMain.class,args);
    }
    @GetMapping("payment/sentinal1")
    public String getInfo(){
        log.info(Thread.currentThread().getName());
        return UUID.randomUUID()+"\tsentinal1";
    }
    @GetMapping("payment/sentinal2")
    public String getInfo1(){
        log.info(Thread.currentThread().getName());
        return UUID.randomUUID()+"\tsentinal2";
    }
    @GetMapping("payment/sentinal3")
    @SentinelResource(value = "sentinal3",blockHandler = "test_handler")
    public String getInfo2(@RequestParam(value = "id",required = false) String id, @RequestParam(value = "number",required = false) String number){
        log.info("接受到的参数：id："+id+"\tnumber:"+number);
        return UUID.randomUUID()+"\tsentinal3";
    }
    public String test_handler(String id, String number, BlockException e){
        return "error!!!!!!!!!!!!!";
    }
}
