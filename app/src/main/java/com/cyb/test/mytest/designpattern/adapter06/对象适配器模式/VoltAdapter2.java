package com.cyb.test.mytest.designpattern.adapter06.对象适配器模式;

import com.cyb.test.mytest.designpattern.adapter06.类适配器模式.FiveVolt;
import com.cyb.test.mytest.designpattern.adapter06.类适配器模式.Volt220;

/**
 * Created by pc on 2017/11/27.
 * 对象适配器模式
 * Adapter角色，将220V的电压转换成5V的电压
 * 直接将要被适配的对象传递到Adapter中，使用组合的形式实现接口兼容的效果，比类适配器方式更加灵活，
 * 他的另一个好处是被适配对象中的对象的方法不被暴露出来，而类适配器由于继承会多出一些奇怪的接口，用户
 * 使用成本增加
 */
public class VoltAdapter2 implements FiveVolt {

    private Volt220 volt220;

    /**
     * 注入被代理对象
     *
     * @param adaptee
     */
    public VoltAdapter2(Volt220 adaptee) {
        this.volt220 = adaptee;
    }

    public int getVolt220() {
        return this.volt220.getVolt220();
    }

    @Override
    public int getVolt5() {
        return 5;
    }
}
