package com.husky.userinfoeurekaclient.reposity;

import com.husky.userinfoeurekaclient.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoReposity extends JpaRepository<UserInfo,Long> {
}
