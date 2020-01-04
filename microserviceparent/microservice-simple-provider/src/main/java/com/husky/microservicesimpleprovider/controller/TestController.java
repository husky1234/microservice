package com.husky.microservicesimpleprovider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/hello")
    public String hello(){
        Map<String,Object> map = new HashMap<>();
        logger.info("hello");
        map.put("hello","你好！");
        return "hello";
    }
}
