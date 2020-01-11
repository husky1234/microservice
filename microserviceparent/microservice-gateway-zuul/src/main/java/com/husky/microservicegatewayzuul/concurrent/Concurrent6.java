package com.husky.microservicegatewayzuul.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Concurrent6 {
    public ReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile int value = 0;

    public void read() {
        try {
            lock.readLock().lock();
            Thread.sleep(1000);
            System.out.println(this.value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            Thread.sleep(1000);
            this.value = (int) Math.random();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        Concurrent6 concurrent6 = new Concurrent6();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> concurrent6.read()).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> concurrent6.write()).start();
        }
    }

}
