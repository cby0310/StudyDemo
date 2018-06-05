package com.cyb.test.mytest.designpattern.strategy04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/5/1.
 * <p>
 * 策略模式：对象行为型
 * 定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
 * <p>
 * 以书本打折为例，常规做法就是将打折算法写在一个类中一个打折算法对应一个方法，或者封装在一个
 * 统一的方法中，使用if...else...或者case来选择具体的算法，这两种方式叫做硬编码，不好维护，
 * 要增加一个算法时就得修改原来的类，违反了OCP开闭原则和单一职责原则。
 * <p>
 */

public class Test {


    public static void main(String[] args) {
        Test main = new Test();
        main.test();

        List<String> strings = new ArrayList<>(2);
        try {
            strings.set(1, "1111111111");
            strings.set(0, "00000000");
            strings.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
