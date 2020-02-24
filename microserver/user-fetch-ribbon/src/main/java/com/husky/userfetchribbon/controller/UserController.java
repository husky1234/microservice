package com.husky.userfetchribbon.controller;

import com.husky.userfetchribbon.entity.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    RestTemplate template;
    @RequestMapping("/all")
    @HystrixCommand(fallbackMethod = "erorr")
    public List<UserInfo> getInfo(){
        return template.getForObject("http://USER-INFO-EUREKACLIENT/user/all",List.class);
    }
    public String erorr(){
        return "404,Not Found";
    }
}
