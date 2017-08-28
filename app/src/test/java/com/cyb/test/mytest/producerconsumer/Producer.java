package com.cyb.test.mytest.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/8/6.
 */

public class Producer implements Runnable {
    private String name;
    private Storage s = null;

    public Producer(String name, Storage s) {
        this.name = name;
        this.s = s;
    }

    public void run() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signal();

        try {
            while (true) {
                Product product = new Product((int) (Math.random() * 10000)); // 产生0~9999随机整数
                System.out.println(name + "准备生产(" + product.toString() + ").");
                s.product(product);
                System.out.println(name + "已生产(" + product.toString() + ").");
                System.out.println("===============");
                Thread.sleep(500);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
