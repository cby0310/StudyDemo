package com.cyb.test.mytest.designpattern.factory.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public CarInterface createCar() {
        return new Bmw();
    }

    @Override
    public ComputerInterface createComputer() {
        return new XiaoMi();
    }
}
