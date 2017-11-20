package com.cyb.test.mytest.designpattern.factory03.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public class XiaoMi implements ComputerInterface {
    @Override
    public void create() {
        System.err.print("xiaomi");
    }
}
