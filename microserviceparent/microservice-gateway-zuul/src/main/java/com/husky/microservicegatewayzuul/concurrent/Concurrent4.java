package com.husky.microservicegatewayzuul.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrent4 {
    public ReentrantLock lock = new ReentrantLock();
    public Condition condition1 = lock.newCondition();
    private volatile int count = 0;
    private volatile boolean flag = true;
    private volatile int rep = 1;

    public void printA() {
        while (flag) {
            if (rep == 1) {
                try {
                    lock.lock();
                    System.out.println("a");
                    rep = 2;
                    condition1.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void printB(){
        while (flag) {
            if (rep == 2) {
                try {
                    lock.lock();
                    System.out.println("b");
                    rep = 3;
                    condition1.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void printC(){
        while (flag) {
            if (rep == 3) {
                try {
                    lock.lock();
                    System.out.println("c");
                    count ++;
                    if (count == 10) flag = false;
                    rep = 1;
                    condition1.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Concurrent4 concurrent4 = new Concurrent4();
        new Thread(()->concurrent4.printB()).start();
        new Thread(()->concurrent4.printC()).start();
        new Thread(()->concurrent4.printA()).start();
    }
}
