package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fhn
 * @create 2021/1/12
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentDao dao;

    @Override
    public int save(Payment payment) {
        return dao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return dao.getPaymentById(id);
    }
}
