package com.cyb.test.mytest.designpattern.Strategy;

/**
 * Created by pc on 2017/5/1.
 */

public class OldBookDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double originPrice) {
        return 0.75 * originPrice;
    }
}
