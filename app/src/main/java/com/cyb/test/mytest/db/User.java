package com.cyb.test.mytest.db;

/**
 * Created by Administrator on 2017/4/24.
 */

public class User {
    public int age;
    public String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
