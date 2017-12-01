package com.cyb.test.mytest.designpattern.observer05;

/**
 * Created by pc on 2017/11/25.
 * <p>
 * 观察者模式：对象行为型模式，也成为 发布-订阅 模式
 * 一种一对多的依赖关系，使得当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。
 * <p>
 * 优点：主要作用就是对象解耦，将观察者和被观察者完全隔离，只依赖于抽象，具有可扩展性，灵活性。
 * 缺点：一个被观察者多个观察者开发调试会比较复杂，一个观察者卡顿会影响整个执行效率，在这种情况下可采用异步方式。
 */

public class Test {

    public static void main(String[] args) {
        Observable<String> observable = new ConcreteObservable();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.notifyObservers("hahaha");
    }
}
