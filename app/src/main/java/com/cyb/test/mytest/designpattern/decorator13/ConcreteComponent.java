package com.cyb.test.mytest.designpattern.decorator13;

/**
 * 具体组件，组件实现类，相当于ContextImpl
 */
public class ConcreteComponent extends Component {
    @Override
    public void operate() {
        System.out.println("operate 0");
    }
}
