package com.atguigu.springcloud;

import com.atguigu.irule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fhn
 * @create 2021/1/13
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(configuration = MyRule.class,name = "CLOUD-PAYMENT-SERVICE")
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
