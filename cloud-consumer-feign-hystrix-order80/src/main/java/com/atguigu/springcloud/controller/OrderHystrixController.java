package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IPaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
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
@DefaultProperties(defaultFallback = "paymentinfo_global_handler")
public class OrderHystrixController {

    @Resource
    private IPaymentHystrixService service;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id) {
        String result = service.paymentinfo_ok(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentinfo_timeouthandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentinfo_timeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String result = service.paymentinfo_timeout(id);
        return result;
    }

    public String paymentinfo_timeouthandler(Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟之后重试或者自己运行出错请检查自己，哭了";
    }

    public String paymentinfo_global_handler() {
        return "我是全局服务降级处理器";
    }

}







