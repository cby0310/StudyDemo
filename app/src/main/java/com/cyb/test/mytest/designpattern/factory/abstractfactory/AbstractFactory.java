package com.cyb.test.mytest.designpattern.factory.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public interface AbstractFactory {
    CarInterface createCar();

    ComputerInterface createComputer();
}
