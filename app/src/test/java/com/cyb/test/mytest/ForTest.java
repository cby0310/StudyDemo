package com.cyb.test.mytest;

/**
 * Created by pc on 2018/7/10.
 */

public class ForTest {
    public synchronized void test() {

        for (char c : "sss".toCharArray()) {
            System.err.println(c);
        }

        for (; ; ) {

        }
    }
}
