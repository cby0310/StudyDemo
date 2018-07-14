package com.cyb.test.mytest.thread;

/**
 * Created by pc on 2018/7/14.
 * 生产者消费者，使用Synchronized结合对象的wait()和notifyAll()方法实现
 */

public class ProducerConsumerSynchronized {

    private static final int CAPACITY = 100;

    private Object[] items = new Object[CAPACITY];
    private int count, putIndex, takeIndex;


    public static void main(String[] args) {
        final ProducerConsumerSynchronized producerConsumerReentrantLock = new ProducerConsumerSynchronized();
        Thread putThread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 1000; i++) {
                    producerConsumerReentrantLock.put(i);
                }
            }
        };

        Thread takeThread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 1000; i++) {
                    Object o = producerConsumerReentrantLock.take();
                }
            }
        };
        putThread.start();
        takeThread.start();
    }

    /**
     * 添加一个数据
     *
     * @param object
     */
    public synchronized void put(Object object) {

//        try {
//            //  添加延时，模拟生产效率低下
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (count == CAPACITY) {
            System.err.println("容量满了，进入等待");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        items[putIndex] = object;
        System.err.println("生产了：" + object);
        putIndex++;
        if (putIndex == CAPACITY) {
            putIndex = 0;
        }
        count++;
        notifyAll();
    }

    /**
     * 取出一个数据
     *
     * @return
     */
    public synchronized Object take() {

        try {
            //  添加延时，模拟消费效率低下
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (count == 0) {
            System.err.println("池子空的，进入等待");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Object x = items[takeIndex];
        takeIndex++;
        if (takeIndex == CAPACITY) {
            takeIndex = 0;
        }
        count--;
        System.err.println("消费了：" + x);
        notifyAll();
        return x;
    }
}
