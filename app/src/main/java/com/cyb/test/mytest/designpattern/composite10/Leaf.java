package com.cyb.test.mytest.designpattern.composite10;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    protected void doSomething() {
        System.out.println("Leaf:" + name);
    }
}
