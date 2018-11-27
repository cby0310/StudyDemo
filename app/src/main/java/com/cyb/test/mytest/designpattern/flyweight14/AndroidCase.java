package com.cyb.test.mytest.designpattern.flyweight14;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;

public class AndroidCase extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String的缓存
        String a = "abc";
        String b = "a" + "bc";

        //Integer缓存 -128~127
        Integer integer = Integer.valueOf(33);

        //Handler中msg的缓存，它不是典型的享元模式，没有内部外部状态。缓存使用链表结构实现，集享元抽象、
        //享元具体、享元工厂于一体，更像一个对象池，是对享元模式的灵活运用，不要在意细节。
        Message message = Message.obtain();
    }
}
