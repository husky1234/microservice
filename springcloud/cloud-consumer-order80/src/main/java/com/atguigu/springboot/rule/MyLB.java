package com.atguigu.springboot.rule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncreament(){
        int current;
        int next;
        for (;;){
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;
            if (this.atomicInteger.compareAndSet(current,next)){
                System.out.println("*****next:"+next);
                return next;
            }
        }
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncreament() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
