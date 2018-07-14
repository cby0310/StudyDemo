package com.cyb.test.mytest.thread;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pc on 2018/7/13.
 */

public class ThreadSafeTest {
    public static void main(String[] args) {

        final ThreadSafeTest threadSafeTest = new ThreadSafeTest();
//        for (int i = 0; i < 1000; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    super.run();
//                    for (int i = 0; i < 99; i++) {
//                        threadSafeTest.addOne();
//                    }
//                }
//            }.start();
//        }

        threadSafeTest.aa();
    }


    private int a = 0;

    private synchronized void addOne1() {
        a++;
        System.err.println(a);
    }

    private ReentrantLock reentrantLock = new ReentrantLock();

    private void addOne() {
        try {
            reentrantLock.lock();
            a++;
            System.err.println(a);
            reentrantLock.newCondition();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void aa() {
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}

        StringBuilder sb3 = sb1;
        sb3.append("bbb");//这时候HashSet里是{"aaabbb","aaabbb"}
        hs.add(sb2);
        System.out.println(hs);
    }

}
