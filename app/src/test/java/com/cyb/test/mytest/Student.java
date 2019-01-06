package com.cyb.test.mytest;

/**
 * Created by chaoyongbing on 2017/11/1 10:32.
 */

public class Student implements Cloneable, IInterface {
    public String name;
    public int age;
    public String fuck = "fuck mm";
    public static int aaaa = 90;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        test();
        test1();
        return super.clone();
    }

    @Override
    public void test() {
        int a = 9;
    }
    public static void test2() {
        int a = 9;
    }

    public final void test1() {
        int a = 9;
    }
}
