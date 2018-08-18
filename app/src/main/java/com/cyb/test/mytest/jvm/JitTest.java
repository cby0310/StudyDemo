package com.cyb.test.mytest.jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2018/7/22.
 * 及时编译器编译结果查看
 */

public class JitTest {
    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        return i * 2;
    }

    public static long sum() {
        int sum = 0;
        for (int i = 1; i <= NUM; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < NUM; i++) {
//            sum();
//        }
//        stackDeepth();
        permGenOom();
    }


    public static void permGenOom() {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.cyb.test.mytest.jvm.FinalizEscapeGC");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int count = 120;

    public static void stackDeepth() {
        count++;
        System.err.println(count);
        stackDeepth();
    }
}
