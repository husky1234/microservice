package com.atguigu.springcloud.service;

import java.io.UnsupportedEncodingException;

public interface IMessageProvider {
    String send() throws UnsupportedEncodingException;
}
