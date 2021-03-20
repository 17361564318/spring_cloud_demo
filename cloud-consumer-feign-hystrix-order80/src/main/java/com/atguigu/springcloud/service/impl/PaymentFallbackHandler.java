package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IPaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author fhn
 * @create 2021/3/10
 * @software idea
 */

@Component
public class PaymentFallbackHandler implements IPaymentHystrixService {
    @Override
    public String paymentinfo_ok(Integer id) {
        return "****paymentinfo_ok   服务器可能不可用，请稍后重试";
    }

    @Override
    public String paymentinfo_timeout(Integer id) {
        return "****paymentinfo_timeout   服务器可能不可用，请稍后重试";
    }
}
