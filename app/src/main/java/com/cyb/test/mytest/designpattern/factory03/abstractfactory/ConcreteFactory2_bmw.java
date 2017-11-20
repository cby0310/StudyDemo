package com.cyb.test.mytest.designpattern.factory03.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 * bwm工厂生产的是宝马车和小米电脑
 */

public class ConcreteFactory2_bmw implements AbstractFactory {
    @Override
    public CarInterface createCar() {
        return new Bmw();
    }

    @Override
    public ComputerInterface createComputer() {
        return new XiaoMi();
    }
}
