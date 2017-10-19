package com.cyb.test.mytest.designpattern.factory.simplefactory;

/**
 * Created by pc on 2017/9/24.
 */

public class Byd implements CarInterface {
    @Override
    public void drive() {
        System.err.println("比亚迪");
    }
}
