package com.husky.controller;

import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.util.concurrent.SettableListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
public class SeindMessageController {
    @Resource
    RabbitTemplate rabbitTemplate;

    @GetMapping("send/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        try {
            String messageId = String.valueOf(UUID.randomUUID());
            String messageDate = message;
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("messageDate", message);
            map.put("createTime", createTime);
            rabbitTemplate.convertAndSend("testexchange", "test", map);
        } catch (AmqpException e) {
            return "消息发送失败，请重新再试！";
        }
        return "ok";
    }
    @GetMapping("sendTopic1/{message}")
    public String sendTopicMessage1(@PathVariable("message") String message){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageDate = message;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageDate",messageDate);
        map.put("createTime",createTime);
        MessageProperties messageProperties = new MessageProperties();
        rabbitTemplate.convertAndSend("1","topic.man",map);
        return "ok";
    }
    @GetMapping("sendTopic2/{message}")
    public String sendTopicMessage2(@PathVariable("message") String message){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageDate = message;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageDate",messageDate);
        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend("topicExchange","topic.#",map);
        return "ok";
    }
}
