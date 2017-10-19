package com.cyb.test.mytest.designpattern.factory.simplefactory;

/**
 * Created by pc on 2017/9/24.
 */

public class Bmw implements CarInterface {
    @Override
    public void drive() {
        System.err.println("宝马车");
    }
}
