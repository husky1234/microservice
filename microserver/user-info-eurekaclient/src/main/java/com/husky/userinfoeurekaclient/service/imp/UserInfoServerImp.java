package com.husky.userinfoeurekaclient.service.imp;

import com.husky.userinfoeurekaclient.pojo.UserInfo;
import com.husky.userinfoeurekaclient.reposity.UserInfoReposity;
import com.husky.userinfoeurekaclient.service.UserinfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServerImp implements UserinfoServer {
    @Autowired
    UserInfoReposity userInfoReposity;
    @Override
    public List<UserInfo> getAll() {
        return userInfoReposity.findAll();
    }
}
