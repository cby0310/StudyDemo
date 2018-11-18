package com.cyb.test.mytest.designpattern.composite10;

/**
 * 抽象部件类
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    protected abstract void doSomething();
}
