package com.cyb.test.mytest.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2018/8/11.
 * -XX:+PrintGCDetails
 */

public class GCTest {


    public static void main(String[] args1) {
//        List list = new ArrayList();
//        for (int i = 0; i < 1000; i++) {
//            ConstantTest constantTest = new ConstantTest("aaaaa" + i);
//            JitTest jitTest = new JitTest();
//            list.add(constantTest);
//        }
//        byte[] allo;
//        allo = new byte[40 * 1024 * 1024];
//        allo = new byte[40 * 1024 * 1024];
//        allo = new byte[Integer.MAX_VALUE];


        for (int i = 0; i < 10; i++) {
            System.err.println(i);
//            try {
                int b = 2 / 0;
//            } catch (Exception e) {
//
//            }
        }

//        System.gc();

    }
}
