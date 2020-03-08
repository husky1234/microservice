package com.atguigu.springcloud.server;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.PaymentEntity;

import java.util.List;

public interface PaymentServer {
    CommentResult<List<PaymentEntity>> getAll();

    CommentResult<PaymentEntity> getById(int id);

    CommentResult<PaymentEntity> addOrder(PaymentEntity paymentEntity);

    CommentResult<PaymentEntity> updateOrder(PaymentEntity paymentEntity);

    CommentResult<PaymentEntity> deleteOrder(int id);
}
