package com.husky.userfeign.feign;

import com.husky.userfeign.entity.UserInfo;
import com.husky.userfeign.feingnerorr.Erorr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "USER-INFO-EUREKACLIENT",fallback = Erorr.class)
public interface UserFeignClient {
    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    public List<UserInfo> getAll();
}
