package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fhn
 * @create 2021/1/12
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String ServerPort;


    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommentResult save(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("******插入结果:" + result);
        if (result > 0) {
            return new CommentResult(200, "插入数据成功，ServerPort：" + ServerPort, result);
        } else {
            return new CommentResult(400, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommentResult(200, "查询成功,ServerPort:  " + ServerPort, payment);
        } else {
            return new CommentResult(400, "沒有对应记录，查詢ID:" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(t -> {
            log.info(t);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach(s -> {
            log.info(s.getInstanceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());
        });
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return ServerPort;
    }
}
