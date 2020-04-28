package com.cyb.test.mytest.jvm.类加载验证;

/**
 * Created by pc on 2018/8/3.
 */

public class a {
    int i = 1;

    public a() {
        i = 9;
        String a1 = "666"+"cyb";
        a1 = "s" + "dd" + a1;
    }
}
