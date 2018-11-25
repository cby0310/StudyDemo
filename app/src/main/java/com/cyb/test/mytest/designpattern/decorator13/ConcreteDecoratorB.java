package com.cyb.test.mytest.designpattern.decorator13;

/**
 * 具体装饰器B
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        System.out.println("operate B");
        super.operate();
    }
}
