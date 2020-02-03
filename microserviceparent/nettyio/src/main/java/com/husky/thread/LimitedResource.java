package com.husky.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LimitedResource implements Runnable {
    final Semaphore semaphore = new Semaphore(10);
    final ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();
    private volatile int count = 0;
    @Override
    public void run() {
        try{
            semaphore.acquire();
            count++;
            System.out.println(count);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           semaphore.release();
        }
    }
}
