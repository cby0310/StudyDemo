package com.cyb.test.mytest.designpattern.strategy04;

/**
 * Created by pc on 2017/5/1.
 */

public class VipDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double originPrice) {
        return 0.5 * originPrice;
    }
}
