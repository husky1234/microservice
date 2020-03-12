package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RestController
public class SendController {

    @Resource
    IMessageProvider iMessageProvider;

    @GetMapping("send")
    public String sendMessage() throws UnsupportedEncodingException {
        iMessageProvider.send();
        return "ok";
    }
}
