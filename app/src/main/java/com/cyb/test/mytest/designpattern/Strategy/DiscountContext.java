package com.cyb.test.mytest.designpattern.Strategy;

import java.util.PriorityQueue;

/**
 * Created by pc on 2017/5/1.
 */

public class DiscountContext {
    private DiscountStrategy discountStrategy;


    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountContext(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getDiscountPrice(double originPrice) {
        if (discountStrategy == null) {
            discountStrategy = new OldBookDiscount();
        }
        return discountStrategy.getDiscount(originPrice);
    }
}
