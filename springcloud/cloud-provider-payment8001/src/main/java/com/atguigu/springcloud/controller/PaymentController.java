package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import com.atguigu.springcloud.server.PaymentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentServer paymentServer;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(method = RequestMethod.GET)
    public CommentResult<List<PaymentEntity>> getAllInfo() {
        log.info(port);
        return paymentServer.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommentResult<PaymentEntity> getById(@PathVariable("id") int id) {
        log.info(id + port);
        return paymentServer.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommentResult<PaymentEntity> addOrder(@RequestBody PaymentEntity paymentEntity) {
        log.info(paymentEntity.toString() + port);
        return paymentServer.addOrder(paymentEntity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommentResult<PaymentEntity> updateOrder(@RequestBody PaymentEntity paymentEntity) {
        log.info(paymentEntity.toString() + port);
        return paymentServer.updateOrder(paymentEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public CommentResult<PaymentEntity> deleteOrder(@PathVariable("id") int id) {
        log.info(id + port);
        return paymentServer.deleteOrder(id);
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******server:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
    @GetMapping("lb")
    public String getPort(){
        return port;
    }
}
