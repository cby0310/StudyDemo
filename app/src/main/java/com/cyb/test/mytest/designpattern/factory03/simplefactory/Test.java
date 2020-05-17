package com.cyb.test.mytest.designpattern.factory03.simplefactory;

/**
 * Created by pc on 2017/9/24.
 * <p>
 * 简单工厂设计模式：创建型模式,又称为 ：静态工厂模式，是工厂方法的一个弱化版本
 * <p>
 * 简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，子类是具体的。
 */

public class Test {
    public static void main(String[] args) {
        CarInterface car = CarFactory.createCar(CarType.BENZ);
        car.drive();
    }

}
