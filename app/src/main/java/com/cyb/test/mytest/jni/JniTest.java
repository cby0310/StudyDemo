package com.cyb.test.mytest.jni;

/**
 * Created by Administrator on 2017/4/26.
 */

public class JniTest {

    static {
        System.loadLibrary("jni-test");
    }

    public static native void get();
}
