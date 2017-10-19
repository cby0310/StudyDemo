package com.cyb.test.mytest.designpattern.factory.abstractfactory;

import org.apache.http.params.CoreConnectionPNames;

/**
 * Created by pc on 2017/9/25.
 * <p>
 * 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构。
 */

public class Test {
    public static void main(String[] args) {
        ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
        concreteFactory1.createCar();
    }
}
