package com.cyb.test.mytest.designpattern.bridge16;

public class SmallCoffee extends AbstractCoffee {
    public SmallCoffee(CoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯" + coffeeAdditives.addSomething() + "咖啡");
    }
}
