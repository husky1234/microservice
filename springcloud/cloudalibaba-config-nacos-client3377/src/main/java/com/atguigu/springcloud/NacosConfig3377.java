package com.atguigu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class NacosConfig3377 {
    @Value("${config.info}")
    private String configInfo;
    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3377.class,args);
    }
    @GetMapping("config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
