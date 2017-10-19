package com.cyb.test.mytest.designpattern.factory.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public class Benz implements CarInterface {
    @Override
    public void drive() {
        System.err.print("benz");
    }
}
