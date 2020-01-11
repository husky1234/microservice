package com.husky.microservicegatewayzuul.test;

public class WriteTest {
    public static User user = new User();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new GetUser(user)).start();
        while (true){
            Thread thread = new Thread(new WriteThread(user));
            thread.start();
            Thread.sleep(150);//当前线程可是主线程主线程休眠其他线程可是不受影响的这个有啥意义呢
            thread.stop();
        }
    }
}
