package com.cyb.test.mytest.designpattern.composite10.transparent_mode;

import com.cyb.test.mytest.designpattern.composite10.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体枝干节点，比如贝贝集团或者贝店
 */
public class Composite2 extends Component2 {
    protected List<Component2> components = new ArrayList<>();

    public Composite2(String name) {
        super(name);
    }

    @Override
    protected void doSomething() {
        System.out.println("Composite:" + name);
        if (null != components) {
            for (Component2 component : components) {
                component.doSomething();
            }
        }
    }


    public void addChild(Component2 component) {
        components.add(component);
    }


    public void removeChild(Component2 component) {
        components.remove(component);
    }
}
