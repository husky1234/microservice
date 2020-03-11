package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public String send() throws UnsupportedEncodingException {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        output.send((MessageBuilder.withPayload(id).build()));
        System.out.println(id);
        return null;
    }
}
