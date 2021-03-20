package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fhn
 * @create 2021/2/9
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface IPaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommentResult<Payment> getPaymentById(@PathVariable("id") Long id);


    @GetMapping("/payment/feign/timeout")
    public String timeout();

}



