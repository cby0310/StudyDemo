package com.cyb.test.mytest.designpattern.factory03.factorymethod.fansheshixian;

import com.cyb.test.mytest.designpattern.factory03.factorymethod.Benz;

/**
 * Created by pc on 2017/11/14.
 */

public class Test {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        factory.createCar(Benz.class).drive();
    }
}
