package com.cyb.test.mytest.designpattern.factory.simplefactory;

/**
 * Created by pc on 2017/9/24.
 * <p>
 * 简单工厂设计模式：创建型模式
 * <p>
 * 简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
 */

public class Test {
    public static void main(String[] args) {
        CarInterface car = CarFactory.createCar(CarType.BENZ);
        car.drive();
    }

}
