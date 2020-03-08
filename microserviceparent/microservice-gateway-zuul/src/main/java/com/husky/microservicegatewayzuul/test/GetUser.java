package com.husky.microservicegatewayzuul.test;

public class GetUser implements Runnable {

    User user;

    public GetUser(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true){
            if (!user.getId().equals(user.getName())){
                System.out.println(user);
            }
            Thread.yield();
        }
    }
}
