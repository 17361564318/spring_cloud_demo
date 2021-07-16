package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fhn
 * @create 2021/4/5
 * @software idea
 */
@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id) {
        return "server .port = " + serverPort + "\t  ,id = " + id;
    }
}
