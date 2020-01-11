package com.husky.microservicegatewayzuul.test;

import java.time.LocalTime;
import java.util.concurrent.locks.ReentrantLock;

public class WriteThread  implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    public User user ;

    public WriteThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                LocalTime now = LocalTime.now();
                String time = now.toString();
                user.setId(time);
                Thread.sleep(1000);
                user.setName(time);
                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
