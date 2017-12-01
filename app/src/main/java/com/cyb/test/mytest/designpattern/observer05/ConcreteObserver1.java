package com.cyb.test.mytest.designpattern.observer05;

/**
 * Created by pc on 2017/11/25.
 */

public class ConcreteObserver1 implements Observer<String> {
    @Override
    public void update(String s) {
        System.err.println(getClass().getSimpleName() + "更新了：" + s);
    }
}
