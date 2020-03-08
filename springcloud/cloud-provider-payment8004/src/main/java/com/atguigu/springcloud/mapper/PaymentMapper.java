package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMapper {
    List<PaymentEntity> getAll();
    PaymentEntity getById(int id);
    int addOrder(PaymentEntity paymentEntity);
    int updateOrder(PaymentEntity paymentEntity);
    int deleteById(int id);
}
