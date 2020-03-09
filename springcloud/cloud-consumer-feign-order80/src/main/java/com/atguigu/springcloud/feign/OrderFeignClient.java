package com.atguigu.springcloud.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-server", fallback = Erorr.class)
public interface OrderFeignClient {
    @GetMapping("/payment/normal/{id}")
    public String getMessage(@PathVariable("id") int id);

//    @HystrixCommand(
//            commandProperties = {
//                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "100"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//            }
//
//    )
    @GetMapping("/payment/timeout/{id}")
    public String getTimeoutMessage(@PathVariable("id") int id);

}
