package com.cyb.test.mytest.designpattern.composite10;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体枝干节点，比如贝贝集团或者贝店
 */
public class Composite extends Component {
    protected List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    protected void doSomething() {
        System.out.println("Composite:"+name);
        if (null != components) {
            for (Component component : components) {
                component.doSomething();
            }
        }
    }

    public void addChild(Component component) {
        components.add(component);
    }

    public void removeChild(Component component) {
        components.remove(component);
    }
}
