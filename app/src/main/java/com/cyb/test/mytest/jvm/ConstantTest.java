package com.cyb.test.mytest.jvm;

/**
 * Created by pc on 2018/8/7.
 */

public class ConstantTest {
    public static final String NAME = "ConstantTest";

    public void main(String[] args) {
        String a = "a" + "1" + "2";
        String b = "b";
        System.out.println(a + b);
    }

    public ConstantTest(String a) {
    }

    public void main1(String args[]) {
        String s = "a12";
        String s1 = "b";
        System.out.println((new StringBuilder()).append(s).append(s1).toString());
    }
}
