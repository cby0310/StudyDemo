package com.cyb.test.mytest.designpattern.factory03.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 * <p>
 * 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。
 * 而工厂方法模式针对的是一个产品的等级结构。
 * <p>
 * 两个产品族，都是在变化的，一个是工厂一个是产品
 * **** car computer
 * Fac1
 * Fac2
 * <p>
 * 而工厂方法中 工厂和产品一一对应：
 * Fac1 -> car1
 * Fac2 -> car2
 * <p>
 * <p>
 * 优点：
 * 显著优点就是分离接口和实现，客户端使用抽象工厂来创建需要的对象，而客户端根本就不知道具体的实现是谁，客户端只是面向
 * 产品的接口编程而已，使其从具体的产品实现中解耦，同时基于接口和实现的分离，在切换产品类时更加灵活容易
 * 缺点：若想增加一个比亚迪工厂，就要增加一个bydcar类，可能一个hongqicomputer类，还有
 * 一个ConcreteFactory2_byd工厂类，导致类剧增，二是不容易扩展新的产品类，现在车配了电脑，例如需又要增加一个空调系统，
 * 就得修改抽象工厂，而且所有的具体工厂类都得修改一遍。
 */

public class Test {
    public static void main(String[] args) {
        ConcreteFactory1_benz concreteFactory1 = new ConcreteFactory1_benz();
        concreteFactory1.createCar().drive();
        concreteFactory1.createComputer().create();
    }
}
