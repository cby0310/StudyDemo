package com.cyb.test.mytest.designpattern.factory03.factorymethod;

/**
 * Created by pc on 2017/9/24.
 */

public class BenzFactory implements FactoryInterface {
    @Override
    public CarInterface createCar() {
        return new Benz();
    }
}
