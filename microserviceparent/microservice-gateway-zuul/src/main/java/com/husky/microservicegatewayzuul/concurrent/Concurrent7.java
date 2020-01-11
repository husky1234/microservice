package com.husky.microservicegatewayzuul.concurrent;



import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrent7 {
    CountDownLatch countDownLatch = new CountDownLatch(5);
    ReentrantLock lock = new ReentrantLock();
    public void testCounDownLatch(){
        try {
            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println("继续等待");
            countDownLatch.await();
            System.out.println("结束！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Concurrent7 concurrent7 = new Concurrent7();
        for (int i = 0; i < 5; i++) {
            new Thread(()->concurrent7.testCounDownLatch()).start();
        }
    }
}
