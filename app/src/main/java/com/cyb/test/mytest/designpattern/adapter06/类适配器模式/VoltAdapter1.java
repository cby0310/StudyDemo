package com.cyb.test.mytest.designpattern.adapter06.类适配器模式;

/**
 * Created by pc on 2017/11/27.
 * 类适配器模式
 * Adapter角色，将220V的电压转换成5V的电压，继承Adaptee，实现Target接口
 */
public class VoltAdapter1 extends Volt220 implements FiveVolt {

    @Override
    public int getVolt220() {
        return super.getVolt220();
    }

    @Override
    public int getVolt5() {
        return 5;
    }
}
