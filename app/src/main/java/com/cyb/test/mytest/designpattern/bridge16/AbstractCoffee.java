package com.cyb.test.mytest.designpattern.bridge16;

public abstract class AbstractCoffee {
    protected CoffeeAdditives coffeeAdditives;

    public AbstractCoffee(CoffeeAdditives coffeeAdditives) {
        this.coffeeAdditives = coffeeAdditives;
    }

    public abstract void makeCoffee();
}
