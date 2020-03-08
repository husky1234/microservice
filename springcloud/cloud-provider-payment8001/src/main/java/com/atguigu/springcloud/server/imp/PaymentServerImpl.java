package com.atguigu.springcloud.server.imp;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.PaymentEntity;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.server.PaymentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServerImpl implements PaymentServer {
    @Resource
    PaymentMapper paymentMapper;

    @Override
    public CommentResult<List<PaymentEntity>> getAll() {
        List all = null;
        try {
            all = paymentMapper.getAll();
        } catch (Exception e) {
            return new CommentResult<List<PaymentEntity>>(500, e.getMessage(), all);
        }
        return new CommentResult<List<PaymentEntity>>(200, "成功！", all);
    }

    @Override
    public CommentResult<PaymentEntity> getById(int id) {
        PaymentEntity entity = null;
        try {
            entity = paymentMapper.getById(id);
        } catch (Exception e) {
            return new CommentResult<PaymentEntity>(500, e.getMessage(), entity);
        }
        return new CommentResult<>(200, "success!", entity);
    }

    @Override
    public CommentResult<PaymentEntity> addOrder(PaymentEntity paymentEntity) {
        int flag = 0;

        try {
            flag = paymentMapper.addOrder(paymentEntity);
            System.out.println(flag);
        } catch (Exception e) {
            return new CommentResult<>(500, e.getMessage(), null);
        }
        return new CommentResult<>(200, "success!", null);
    }

    @Override
    public CommentResult<PaymentEntity> updateOrder(PaymentEntity paymentEntity) {

        try {
            paymentMapper.updateOrder(paymentEntity);
            return new CommentResult<>(200, "success!", null);
        } catch (Exception e) {
            return new CommentResult<>(500, e.getMessage(), null);
        }

    }

    @Override
    public CommentResult<PaymentEntity> deleteOrder(int id) {

        try {
            paymentMapper.deleteById(id);
            return new CommentResult<>(200, "success!", null);
        } catch (Exception e) {
            return new CommentResult<>(500, e.getMessage(), null);
        }
    }
}
