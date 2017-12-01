package com.cyb.test.mytest.exception;

/**
 * Created by chaoyongbing on 2017/10/27 13:18.
 */

public class Test {
    public static void main(String[] args) {
        System.err.print(test());
    }

    public static int test() {
        int i = 0;
        try {
            i = 2;
            return i;
        } catch (Exception e) {

        } finally {
            return i;
        }
    }

}
