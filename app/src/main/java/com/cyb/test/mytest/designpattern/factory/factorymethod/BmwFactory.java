package com.cyb.test.mytest.designpattern.factory.factorymethod;

/**
 * Created by pc on 2017/9/24.
 */

public class BmwFactory implements FactoryInterface {
    @Override
    public CarInterface createCar() {
        return new Bmw();
    }
}
