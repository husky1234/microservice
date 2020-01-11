package com.husky.microservicegatewayzuul.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OrderPrint implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    volatile int flag = 1;
    volatile int count = 0;
    volatile boolean f = true;

    public static void printa() {
        System.out.println("a");
    }

    public static void printb() {
        System.out.println("b");
    }

    public static void printc() {
        System.out.println("c");
    }

    @Override
    public void run() {
        while (f) {
            lock.lock();
            try {
                if (flag == 1) {
                    condition.signal();
                    printa();
                    flag = 2;
                    condition.await();
                }
                if (flag == 2) {
                    condition.signal();
                    printb();
                    flag = 3;
                    condition.await();
                }
                if (flag == 3) {
                    condition.signal();
                    printc();
                    flag = 1;
                    count++;
                    if (count == 10) f = false;
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        OrderPrint orderPrint = new OrderPrint();
        for (int i = 0; i < 3; i++) {
            new Thread(orderPrint).start();
        }
    }
}
