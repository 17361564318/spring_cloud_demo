package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fhn
 * @create 2021/3/27
 * @software idea
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ClientConfigMain3355.class, args);
    }
}
