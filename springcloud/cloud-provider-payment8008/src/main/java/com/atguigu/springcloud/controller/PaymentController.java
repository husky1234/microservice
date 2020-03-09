package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.server.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    private volatile int count = 0;
    @Resource
    PaymentService paymentService;

    @GetMapping("/normal/{id}")
    public String getMessage(@PathVariable("id") int id){
        log.info(id+"");
        return paymentService.normal(id);
    }
    @GetMapping("/timeout/{id}")
    public String getTimeoutMessage(@PathVariable("id") int id){
        count++;
        System.out.println(count);
        log.info(id+"");
        try {
            return paymentService.timeOut(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
