package com.cyb.test.mytest.designpattern.strategy;

/**
 * Created by pc on 2017/5/1.
 * 策略模式：对象行为型
 *
 * 定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
 */

public class Test {


    public static void main(String[] args) {
        Test main = new Test();
        main.test();
    }

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
