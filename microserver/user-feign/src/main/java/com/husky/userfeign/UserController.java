package com.husky.userfeign;

import com.husky.userfeign.entity.UserInfo;
import com.husky.userfeign.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserFeignClient userFeignClient;
    @RequestMapping("/all")
    public List<UserInfo> getAll(){
        return userFeignClient.getAll();
    }
}
