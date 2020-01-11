package com.husky.microservicegatewayzuul.concurrent.mycontainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Mycontainer {
    private  volatile ArrayList<Integer> container = new ArrayList<>();

    public void add(Integer num){
        container.add(num);
    }

    public int size(){
        return container.size();
    }

    public static void main(String[] args) {
        Mycontainer mycontainer = new Mycontainer();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                mycontainer.add(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                if (mycontainer.size() == 5){
                    break;
                }
            }
                System.out.println("已经完成任务请退出！");
        }).start();
    }
}
