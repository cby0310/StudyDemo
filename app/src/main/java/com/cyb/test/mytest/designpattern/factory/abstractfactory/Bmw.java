package com.cyb.test.mytest.designpattern.factory.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public class Bmw implements CarInterface {
    @Override
    public void drive() {
        System.err.print("bmw");
    }
}
