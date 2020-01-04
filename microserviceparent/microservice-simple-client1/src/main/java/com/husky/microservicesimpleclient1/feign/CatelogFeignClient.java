package com.husky.microservicesimpleclient1.feign;

import com.husky.microservicesimpleclient1.pojo.BaseCatolog1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provide-category")
public interface CatelogFeignClient {
    @RequestMapping(value = "/catelog/oneInfo/{id}", method = RequestMethod.GET)
    BaseCatolog1 getCatelogInfo(@PathVariable("id") int id);
}
