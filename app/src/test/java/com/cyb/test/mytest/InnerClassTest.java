package com.cyb.test.mytest;

import org.junit.Test;

import java.lang.reflect.Field;

public class InnerClassTest {
    private String name;

    InnerClass innerClass;

    public void setInnerClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }

    public void method(final String name) {
        final int age = 0;
        //任何情况下，匿名内部类一定会持有一个外部类的引用
        //为什么要final?匿名内部类对象的生命周期可能要比外部类对象要长，这个时候内部类为了要访问到外部的对象，就会复制一份，但复制了
        //之后假如外部又更改了值，这个时候就会出现结果错乱，为了结果正确，那就只能final
        setInnerClass(new InnerClass() {
            @Override
            public void aa() {
                System.err.println(name + " " + age);
                Field[] field = this.getClass().getDeclaredFields();
                for (int i = 0; i < field.length; i++) {
                    System.out.println(field[i].getName());
                }
            }
        });
    }

    interface InnerClass {
        void aa();
    }

    @Test
    public void test() {
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.method(innerClassTest.name);
        innerClassTest.innerClass.aa();
    }


}
