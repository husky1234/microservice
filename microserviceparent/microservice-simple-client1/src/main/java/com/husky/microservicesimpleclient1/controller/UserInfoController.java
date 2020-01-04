package com.husky.microservicesimpleclient1.controller;


import com.husky.microservicesimpleclient1.feign.CatelogFeignClient;
import com.husky.microservicesimpleclient1.pojo.BaseCatolog1;
import com.husky.microservicesimpleclient1.pojo.UserInfo;
import com.husky.microservicesimpleclient1.service.UserInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    CatelogFeignClient catelogFeignClient;

    @RequestMapping("/id/{id}")
    public UserInfo getUserInfo(@PathVariable(name = "id") int id){
        return userInfoService.getUserInfo(id);
    }
    @RequestMapping("/catalog/{id}")
    @HystrixCommand(fallbackMethod = "getCatalogFallback")
    public BaseCatolog1 getCatalog(@PathVariable(value = "id") int id){
        logger.info(id+"");
        return catelogFeignClient.getCatelogInfo(id);
    }

    public BaseCatolog1 getCatalogFallback(int id){
        BaseCatolog1 baseCatolog1 = new BaseCatolog1();
        baseCatolog1.setId(1);
        baseCatolog1.setName("调用失败!");
        return baseCatolog1;
    }
}
