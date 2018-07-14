package com.cyb.test.mytest.volatiletest;

/**
 * Created by pc on 2017/9/17.
 */

public class Test2 {
    public static void main(String[] args) {
        final Test2 test2 = new Test2();
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
            Thread.sleep(12453);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                super.run();
                test2.setShutdown();
            }
        }.start();
    }


    private /*volatile*/ boolean shutdown;//保证其它线程及时停止（但是他妈的运行了几遍没看出有什么鸡巴区别，都能及时停止？？？）


    public void setShutdown() {
        shutdown = true;
        System.err.println(getTime() + Thread.currentThread().getName() + ":设置结束标志");
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
