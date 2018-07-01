package com.cyb.test.mytest;

/**
 * Created by yongbing.chao on 2018/6/25.
 */

public class zhuangxiang {

    public void main() {
        Long a = 128L;
        Long b = 128L;

        System.err.println(a == b);
        System.err.println(a == 128L);

        Long c = 127L;
        Long d = 127L;

        System.err.println(c == d);
        System.err.println(c == 127L);
    }
}
