package com.atguigu.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fhn
 * @create 2021/1/25
 * 注意，此关于ribbon的算法配置类不能写到@SpringBootApplication注解同包以及子包下面的任何类里面。
 */
@Configuration
public class MyRule {
    //將ribbon的算法修改为随机算法
    @Bean
    public IRule getIRule() {
        return new RandomRule();//定义为随机算法
    }

}
