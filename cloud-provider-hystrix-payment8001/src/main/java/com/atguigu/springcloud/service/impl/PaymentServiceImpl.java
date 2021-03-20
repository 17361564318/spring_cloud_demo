package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author fhn
 * @create 2021/3/8
 * @software idea
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentinfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_ok ,id = " + id + "\t" + "哈哈";
    }


    @Override
    @HystrixCommand(fallbackMethod = "paymentinfo_timeouthandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentinfo_timeout(Integer id) {
        int number = 3;
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_timeout ,id = " + id + "\t" + "嘿嘿超時(秒)：";
    }

    public String paymentinfo_timeouthandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "系統繁忙，请稍后再试 ,id = " + id + "\t" + "我是超时处理器";
    }

    //    ===服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启短路由
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//至少要达到的请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),//窗口期时长，也就是规定了多久使时间内达到阈值才会触发熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//请求失败百分比
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试,/o*o/  ,id = " + id;
    }


}
