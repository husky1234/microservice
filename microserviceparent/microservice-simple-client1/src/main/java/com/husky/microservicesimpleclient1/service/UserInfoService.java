package com.husky.microservicesimpleclient1.service;

import com.husky.microservicesimpleclient1.pojo.UserInfo;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;


public interface UserInfoService {
    UserInfo getUserInfo(int id);
}
