package com.cyb.test.mytest.designpattern.composite10.transparent_mode;

/**
 * 抽象部件类
 */
public abstract class Component2 {
    protected String name;

    public Component2(String name) {
        this.name = name;
    }

    protected abstract void doSomething();

    protected abstract void addChild(Component2 component2);

    protected abstract void removeChild(Component2 component2);
}
