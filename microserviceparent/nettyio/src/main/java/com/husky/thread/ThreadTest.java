package com.husky.thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("hello!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        },"thread1");
        thread.start();
        thread.interrupt();
        System.out.println(thread.getName());
    }
}
