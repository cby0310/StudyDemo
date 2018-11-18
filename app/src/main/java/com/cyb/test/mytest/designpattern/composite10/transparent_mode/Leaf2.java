package com.cyb.test.mytest.designpattern.composite10.transparent_mode;

public class Leaf2 extends Component2 {
    public Leaf2(String name) {
        super(name);
    }

    @Override
    protected void doSomething() {
        System.out.println("Leaf:" + name);
    }

    @Override
    protected void addChild(Component2 component2) {
        throw new UnsupportedOperationException("不支持add");
    }

    @Override
    protected void removeChild(Component2 component2) {
        throw new UnsupportedOperationException("不支持rm");
    }
}
