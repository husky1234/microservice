package com.husky.microservicesimpleclient1.reposity;

import com.husky.microservicesimpleclient1.pojo.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoReposity extends JpaRepository<UserInfo,Integer> {
    UserInfo findById(int id);
}
