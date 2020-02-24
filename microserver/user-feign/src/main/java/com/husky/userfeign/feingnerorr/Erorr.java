package com.husky.userfeign.feingnerorr;

import com.husky.userfeign.entity.UserInfo;
import com.husky.userfeign.feign.UserFeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Erorr implements UserFeignClient {
    @Override
    public List<UserInfo> getAll() {

        return new ArrayList<>();
    }
}
