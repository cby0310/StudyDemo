package com.cyb.test.mytest.volatiletest;

/**
 * Created by pc on 2017/9/17.
 */

public class Test {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("马上执行");
        while (true) {
            System.out.println(td.isFlag());
            if (td.isFlag()) {
                System.out.println("12121------------------");
                break;
            }
        }

    }


    static class ThreadDemo implements Runnable {
        private volatile boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            flag = true;
            System.out.println("flag=" + isFlag());
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}