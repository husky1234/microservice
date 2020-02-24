package com.husky.userinfoeurekaclient.controller;

import com.husky.userinfoeurekaclient.pojo.UserInfo;
import com.husky.userinfoeurekaclient.service.UserinfoServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserinfoServer userinfoServer;
    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<UserInfo> getAll(){
        return userinfoServer.getAll();
    }
    public List<UserInfo> error(){
        return new ArrayList<>();
    }
}
