package com.husky.thread;

public class ThreadTest1 {
    public static void main(String[] args) {
        LimitedResource limitedResource = new LimitedResource();
        for (int i = 0; i < 1000; i++) {
            new Thread(limitedResource).start();
        }
    }
}
