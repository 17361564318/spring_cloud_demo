package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fhn
 * @create 2021/4/5
 * @software idea
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9002.class, args);
    }
}
