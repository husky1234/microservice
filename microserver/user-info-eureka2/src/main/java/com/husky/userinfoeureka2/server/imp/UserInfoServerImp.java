package com.husky.userinfoeureka2.server.imp;


import com.husky.userinfoeureka2.entity.UserInfo;
import com.husky.userinfoeureka2.mapper.UserInfoMapper;
import com.husky.userinfoeureka2.server.UserinfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServerImp implements UserinfoServer {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.getAll();
    }
}
