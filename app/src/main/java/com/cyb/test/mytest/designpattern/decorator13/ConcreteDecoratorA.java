package com.cyb.test.mytest.designpattern.decorator13;

/**
 * 具体装饰器A,相当于ContextThemeWrapper
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("operate A");
    }
}
