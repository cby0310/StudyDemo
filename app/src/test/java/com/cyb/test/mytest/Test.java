package com.cyb.test.mytest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chaoyongbing on 2017/12/1 10:31.
 */

public class Test {
    public static void main(String[] args) {
        ArrayList<Date> list = new ArrayList<Date>();
        list.add(new Date());
        Date myDate = list.get(0);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ss");
    }


    //    @org.junit.Test
    public void testInstanceOf() {
        List<String> list = new ArrayList<>();
        System.err.println(list instanceof List<?>);
    }


    @org.junit.Test
    public void testInteger() throws InterruptedException {
        Integer a = Integer.valueOf(121);
        Integer a1 = Integer.valueOf(121);

        a = 121;
        System.out.println(a == a1);


        String s = "aa" + "bb";
        String s1 = s + "cc";


        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();
        t.join();
        System.out.println("执行结束");
    }
}
