package com.cyb.test.mytest.volatiletest;

/**
 * Created by pc on 2017/9/17.
 */

public class Test2 {

    private final Test2 b;

    public Test2() {
        b = null;
    }

    public Test2(Test2 b1) {
        b = b1;
    }

    public static void main(String[] args) {
        final Test2 test2 = new Test2(new Test2());
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    test2.doWork();
                }
            };
            thread.setName("线程" + i);
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                super.run();
                test2.setShutdown(true);
//                int a = 9;
                test2.setShutdown(false);
            }
        }.start();
    }


    private volatile boolean shutdown;//保证其它线程及时停止（但是他妈的运行了几遍没看出有什么鸡巴区别，都能及时停止？？？）


    public void setShutdown(boolean b) {
        shutdown = b;
        System.err.println(getTime() + Thread.currentThread().getName() + ":设置结束标志:" + b);
    }


    public void doWork() {
        while (!shutdown) {
            System.err.println(getTime() + Thread.currentThread().getName() + ":执行任务");
        }
    }

    private long getTime() {
//        return new Date().getTime();
        return System.currentTimeMillis();
    }

}
