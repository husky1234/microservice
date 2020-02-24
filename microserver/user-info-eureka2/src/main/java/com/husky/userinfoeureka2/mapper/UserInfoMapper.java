package com.husky.userinfoeureka2.mapper;

import com.husky.userinfoeureka2.entity.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserInfoMapper {
    List<UserInfo> getAll();
}
