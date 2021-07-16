package com.atguigu.sprigcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fhn
 * @create 2021/7/16
 * @software idea
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrder83.class, args);
    }
}
