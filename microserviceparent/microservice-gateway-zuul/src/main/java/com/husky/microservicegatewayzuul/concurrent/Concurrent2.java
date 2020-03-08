package com.husky.microservicegatewayzuul.concurrent;

public class Concurrent2 {
    public synchronized void say() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("hello,welcome!");
    }
    public void listen() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("I'm listen music!");
    }

    public static void main(String[] args) {
        Concurrent2 concurrent2 = new Concurrent2();
        new Thread(()-> {
            try {
                concurrent2.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                concurrent2.listen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
