package com.cyb.test.mytest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void test() {
        char a = 'a';
        System.err.print(++a);
        System.err.print(a + 1);
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

    @org.junit.Test
    public void testAsList() {
        Integer a[] = {2, 3, 44, 555, 9};
        System.out.println(Arrays.asList(a).toArray());
        //asList(a)返回的是Arrays中的一个内部类ArrayList，不支持add和remove方法
//        System.out.println(Arrays.asList(a).add(4));
        List<Student> list = new ArrayList<>();
        list.add(new Student("xiaoming", 25));
        list.add(new Student("xiaohua", 22));

        List<Student> list1 = new ArrayList<>(list);
        list1.get(0).age = 0;

        //subList的操作是在原来对象上的操作
        List<Student> list2 = list.subList(0, list.size());

//        list2.add("c");

        System.out.println(list.equals(list1));
        System.out.println(list.equals(list2));
        print(list);
        System.out.println(list.size() + "   " + list1.size() + "   " + list2.size());

    }

    private void print(List<Student> list) {
        for (Student s : list) {
            System.out.print(s + "  ");
        }
    }


    public void testHttp() throws IOException {

        URL url = new URL("");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
            bufferedReader.readLine();
        }
    }


}
