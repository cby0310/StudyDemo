package com.cyb.test.mytest.designpattern.proxy07;

/**
 * Created by pc on 2017/9/20.
 * <p>
 * 目标对象：单身汪 Jesse
 */

public class Jesse implements IService {
    @Override
    public void findGirl(String name, int age) {
        System.err.println("找到了一个妹子：" + name + "-" + age + "岁");
    }

    @Override
    public void findBoy(String name) {
        System.err.println("找到了一个汉子：" + name);
    }
}
