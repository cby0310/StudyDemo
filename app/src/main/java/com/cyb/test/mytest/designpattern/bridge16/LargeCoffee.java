package com.cyb.test.mytest.designpattern.bridge16;

public class LargeCoffee extends AbstractCoffee {
    public LargeCoffee(CoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯" + coffeeAdditives.addSomething() + "咖啡");
    }
}
