package com.cyb.test.mytest.designpattern.factory03.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 *
 * benz工厂生产的是奔驰车和联想电脑
 *
 */

public class ConcreteFactory1_benz implements AbstractFactory {
    @Override
    public CarInterface createCar() {
        return new Benz();
    }

    @Override
    public ComputerInterface createComputer() {
        return new Lenovo();
    }
}
