package com.husky.microservicegatewayzuul.concurrent;

public class Concurrent3 {
    volatile int count = 0;
    public void add(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Concurrent3 concurrent3 = new Concurrent3();
        for (int i = 0; i < 10; i++) {
            new Thread(()->concurrent3.add()).start();
        }
        System.out.println(concurrent3.count);
    }
}
