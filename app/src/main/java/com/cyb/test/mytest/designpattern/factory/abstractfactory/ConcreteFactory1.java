package com.cyb.test.mytest.designpattern.factory.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public CarInterface createCar() {
        return new Benz();
    }

    @Override
    public ComputerInterface createComputer() {
        return new Lenovo();
    }
}
