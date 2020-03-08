package com.husky.microservicesimpleclient1.controller;


import com.husky.microservicesimpleclient1.pojo.UserInfo;
import com.husky.microservicesimpleclient1.service.UserInfoService;
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

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/id/{id}")
    public UserInfo getUserInfo(@PathVariable(name = "id") int id){
        return userInfoService.getUserInfo(id);
    }
}
