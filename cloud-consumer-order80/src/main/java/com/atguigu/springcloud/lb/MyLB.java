package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fhn
 * @create 2021/2/9
 */
@Component
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public final int getAndCrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
//            这里的数字代表的是Integer所能代表的最大值
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问，次数next  = " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndCrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
