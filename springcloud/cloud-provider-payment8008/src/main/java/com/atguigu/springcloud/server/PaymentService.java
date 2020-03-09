package com.atguigu.springcloud.server;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String normal(int id) {
        return "Thread:" + Thread.currentThread().getName() + "id:" + id;
    }

    @HystrixCommand(fallbackMethod = "pymentInfo_timeoutHandlera", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String timeOut(int id) throws InterruptedException {
        if (id < 0){
            throw new RuntimeException();
        }

        return "Thread:" + Thread.currentThread().getName() + "id:" + IdUtil.fastSimpleUUID();
    }

    public String pymentInfo_timeoutHandlera(int id) {
        return "线程池：  " + Thread.currentThread().getName() + "pymentInfo_timeoutHandlera, id: " + id + "请稍后再试！";
    }
}
