package com.cyb.test.mytest.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pc on 2018/7/14.
 * 生产者消费者，使用重入锁Condition和Condition实现
 */

public class ProducerConsumerReentrantLock {

    private Lock lock = new ReentrantLock(true);
    private Condition full = lock.newCondition();//容量满时进入等待
    private Condition empty = lock.newCondition();//容量空时进入等待

    private static final int CAPACITY = 100;

    private Object[] items = new Object[CAPACITY];
    private int count, putIndex, takeIndex;


    public static void main(String[] args) {
        final ProducerConsumerReentrantLock producerConsumerReentrantLock = new ProducerConsumerReentrantLock();
        Thread putThread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (; ; ) {
                    producerConsumerReentrantLock.put(1);
                }
            }
        };
        Thread putThread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (; ; ) {
                    producerConsumerReentrantLock.put(1);
                }
            }
        };
        Thread putThread3 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (; ; ) {
                    producerConsumerReentrantLock.put(1);
                }
            }
        };

        Thread takeThread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (; ; ) {
                    Object o = producerConsumerReentrantLock.take();
                }
            }
        };
        Thread takeThread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (; ; ) {
                    Object o = producerConsumerReentrantLock.take();
                }
            }
        };
        putThread.setName("生产线程1");
        putThread.start();
//        putThread2.setName("生产线程2");
//        putThread2.start();
//        putThread3.setName("生产线程3");
//        putThread3.start();
        takeThread.setName("消费线程1");
        takeThread.start();
        takeThread2.setName("消费线程2");
        takeThread2.start();
    }

    /**
     * 添加一个数据
     *
     * @param object
     */
    public void put(Object object) {

//        try {
//            //  添加延时，模拟生产效率低下
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.err.println("put等待锁");
        lock.lock();
        System.err.println(Thread.currentThread().getName() + "拿到了锁");
        try {
            while (count == CAPACITY) {//多个消费者时这里需要用while
                System.err.println(Thread.currentThread().getName() + "容量满了，进入等待");
                full.await();//这一句会释放掉锁，把资源给其它线程
                System.err.println(Thread.currentThread().getName() + "被唤醒,当前数量" + count);
            }
            items[putIndex] = object;
            System.err.println(Thread.currentThread().getName() + "生产了：" + object);
            putIndex++;
            if (putIndex == CAPACITY) {
                putIndex = 0;
            }
            count++;
            System.out.println("容量池内数量：" + count);
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.err.println(Thread.currentThread().getName() + "释放了锁");
        }
    }

    /**
     * 取出一个数据
     *
     * @return
     */
    public Object take() {

//        try {
//            //  添加延时，模拟消费效率低下
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.err.println("take等待锁");
        lock.lock();
//        System.err.println("take拿到了锁");
        try {
            while (count == 0) {
                System.err.println("池子空的，进入等待");
                empty.await();
            }

            Object x = items[takeIndex];
            takeIndex++;
            if (takeIndex == CAPACITY) {
                takeIndex = 0;
            }
            count--;
            System.err.println(Thread.currentThread().getName() + "消费了：" + x);
            full.signal();
            return x;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
