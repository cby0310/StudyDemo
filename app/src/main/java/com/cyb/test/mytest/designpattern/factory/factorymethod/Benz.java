package com.cyb.test.mytest.designpattern.factory.factorymethod;


/**
 * Created by pc on 2017/9/24.
 */

public class Benz implements CarInterface {
    @Override
    public void drive() {
        System.err.println("奔驰车");
    }
}
