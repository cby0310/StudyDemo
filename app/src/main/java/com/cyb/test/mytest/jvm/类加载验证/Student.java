package com.cyb.test.mytest.jvm.类加载验证;

import java.util.List;

/**
 * Created by pc on 2018/7/21.
 */

class Student {
    public static String name = "cyb";
    public static final int age = 25;

    static {
        System.err.println("Student 初始化");
    }

    public void add(Student... students) {
    }


    public static void method(List<String> a1) {
    }

    public final int add(int a, int b) {
        return add2(a, b) + add(a, b);
    }

    public final int add2(int a, int b) {
        return a + b;
    }

}
