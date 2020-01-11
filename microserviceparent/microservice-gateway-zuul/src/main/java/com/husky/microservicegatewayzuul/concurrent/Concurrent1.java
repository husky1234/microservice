package com.husky.microservicegatewayzuul.concurrent;

public class Concurrent1 implements Runnable {
    private  int count = 10;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+":"+count);
    }

    public static void main(String[] args) {
        Concurrent1 concurrent1 = new Concurrent1();
        for (int i = 0; i < 10; i++) {
            new Thread(concurrent1).start();
        }
    }
}
