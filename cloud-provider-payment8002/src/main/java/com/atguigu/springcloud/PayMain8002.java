package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fhn
 * @create 2021/1/12
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //启用服务发现
public class PayMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain8002.class, args);
    }
}
