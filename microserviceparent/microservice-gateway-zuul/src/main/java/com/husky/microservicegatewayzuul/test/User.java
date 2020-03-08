package com.husky.microservicegatewayzuul.test;

public class User {
    private String name;
    private String id;

    public User() {
        this.name = 0+"";
        this.id = 0+"";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
