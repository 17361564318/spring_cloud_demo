package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author fhn
 * @create 2021/1/18
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/consul")
    public String paymentconsul() {
        return "payment with consul serverPort :" + serverPort + "\t " + UUID.randomUUID().toString();
    }


}
