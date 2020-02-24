package com.husky.userinfoeureka2.controller;


import com.husky.userinfoeureka2.entity.UserInfo;
import com.husky.userinfoeureka2.server.UserinfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserinfoServer userinfoServer;
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<UserInfo> getAll(){
        return userinfoServer.getAll();
    }
}
