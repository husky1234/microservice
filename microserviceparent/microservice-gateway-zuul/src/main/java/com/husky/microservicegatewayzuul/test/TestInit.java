package com.husky.microservicegatewayzuul.test;

public class TestInit {

    static {
        System.out.println("1");
    }
    public TestInit() {
        System.out.println("TestInit!");
    }
    public int test(){
        int x = 1;
        return x > 1 ? 2:3;
    }
}

class SubClass extends TestInit{
    static {
        System.out.println("2");
    }

    public SubClass() {
        System.out.println("Subclass");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }
}
