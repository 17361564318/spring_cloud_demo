package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface IPaymentService {

    public String paymentinfo_ok(Integer id);

    public String paymentinfo_timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);

    }


