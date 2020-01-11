package com.husky.microservicegatewayzuul.test;

import sun.text.normalizer.ReplaceableUCharacterIterator;

import java.util.HashMap;

public class Kafka {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            loadReplicasFromDisk();
            Thread.sleep(1000);
        }
    }
    private static void loadReplicasFromDisk(){
        HashMap<String,Integer> map = new HashMap<>();
    }
}
