package com.cyb.test.mytest.designpattern.Strategy;

/**
 * Created by pc on 2017/5/1.
 */

public class Main {

    public void test() {
        //默认旧书打折
        DiscountContext discountContext = new DiscountContext(null);
        double result = discountContext.getDiscountPrice(25.2);
        System.err.println(result);

        discountContext.setDiscountStrategy(new VipDiscount());
        result = discountContext.getDiscountPrice(25.2);
        System.err.println(result);
    }
}
