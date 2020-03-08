package com.husky.microservicegatewayzuul.test;
public class Algrithm {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num^nums[i];
        }
        System.out.println(num);
    }
}
