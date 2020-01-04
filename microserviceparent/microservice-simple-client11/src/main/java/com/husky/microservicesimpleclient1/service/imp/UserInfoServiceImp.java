package com.husky.microservicesimpleclient1.service.imp;


import com.husky.microservicesimpleclient1.pojo.UserInfo;
import com.husky.microservicesimpleclient1.reposity.UserInfoReposity;
import com.husky.microservicesimpleclient1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImp implements UserInfoService {

    @Autowired
    UserInfoReposity userInfoReposity;
    @Override
    public UserInfo  getUserInfo(int id) {
        return userInfoReposity.findById(id);
    }
}
