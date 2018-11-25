package com.cyb.test.mytest.designpattern.decorator13;

/**
 * 抽象装饰器，相当于ContextWrapper
 */
public abstract class Decorator extends Component {
    //引用要修饰的对象
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
