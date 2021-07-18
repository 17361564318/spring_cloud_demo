package com.atguigu.sprigcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fhn
 * @create 2021/7/16
 * @software idea
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String urlPath;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(urlPath + "/payment/nacos/" + id, String.class);
    }

}
