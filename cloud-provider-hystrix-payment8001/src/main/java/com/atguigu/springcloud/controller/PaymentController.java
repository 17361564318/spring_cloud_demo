package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fhn
 * @create 2021/3/8
 * @software idea
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id) {
        String result = service.paymentinfo_ok(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout(@PathVariable("id") Integer id) {
        String result = service.paymentinfo_timeout(id);
        log.info("result:" + result);
        return result;
    }

    //    ==服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = service.paymentCircuitBreaker(id);
        log.info("***result " + result);
        return result;
    }


}




