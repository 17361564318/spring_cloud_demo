package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fhn
 * @create 2021/4/4
 * @software idea
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaProvider9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProvider9001.class, args);
    }
}

