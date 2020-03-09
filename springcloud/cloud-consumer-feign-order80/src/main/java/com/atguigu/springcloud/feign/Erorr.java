package com.atguigu.springcloud.feign;

import org.springframework.stereotype.Component;

@Component
public class Erorr implements OrderFeignClient {


    @Override
    public String getMessage(int id) {
        return "出错了，请稍后再试！";
    }

    @Override
    public String getTimeoutMessage(int id) {
        return "出错了，请稍后再试！";
    }
}
