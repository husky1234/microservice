package com.husky.microservicegatewayzuul.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Concurrent9 extends RecursiveTask<Long> {

    static final int THRESHOLD = 10000;

    long start;

    long end;

    public Concurrent9(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute){
            for (long i = start; i <= end; i++){
                sum += i;
            }
        }else{
            long step = (end - start)/100;
            long pos = start;
            ArrayList<Concurrent9> tasks = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) lastOne = end;
                Concurrent9 concurrent9 = new Concurrent9(pos,lastOne);
                pos = lastOne+1;
                tasks.add(concurrent9);
                concurrent9.fork();
            }
            for (Concurrent9 task : tasks) {
                sum += task.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Concurrent9 concurrent9 = new Concurrent9(0,20000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(concurrent9);
        System.out.println(submit.get());
    }
}
