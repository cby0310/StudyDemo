package com.cyb.test.mytest.designpattern.factory.factorymethod;

/**
 * Created by pc on 2017/9/24.
 * <p>
 * 工厂方法设计模式：创建型模式
 * <p>
 * 工厂方法模式是有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
 */

public class Test {
    public static void main(String[] args) {
        BenzFactory benzFactory = new BenzFactory();
        benzFactory.createCar().drive();
    }

}
