package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author fhn
 * @create 2021/1/12
 */
public interface IPaymentService {
    public int save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
