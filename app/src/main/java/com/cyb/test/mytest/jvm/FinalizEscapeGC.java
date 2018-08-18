package com.cyb.test.mytest.jvm;

/**
 * Created by pc on 2018/7/8.
 */

public class FinalizEscapeGC {
    public static FinalizEscapeGC INSTANCE = null;

    public static void main(String[] args) {
        INSTANCE = new FinalizEscapeGC();

        //第一次回收时会拯救自己
        INSTANCE = null;
        System.gc();
        try {
            //因为finalize方法优先级比较低，暂停一下
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (INSTANCE != null) {
            System.out.println("还活着");
        } else {
            System.out.println("回收了");
        }

        //第2次回收时失效，因为finalize方法只会调一次
        INSTANCE = null;
        System.gc();
        try {
            //因为finalize方法优先级比较低，暂停一下
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (INSTANCE != null) {
            System.out.println("还活着");
        } else {
            System.out.println("回收了");
        }


    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法执行了");
        INSTANCE = this;
    }
}
