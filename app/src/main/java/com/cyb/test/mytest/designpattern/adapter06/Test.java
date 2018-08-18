package com.cyb.test.mytest.designpattern.adapter06;

import com.cyb.test.mytest.designpattern.adapter06.对象适配器模式.VoltAdapter2;
import com.cyb.test.mytest.designpattern.adapter06.类适配器模式.Volt220;
import com.cyb.test.mytest.designpattern.adapter06.类适配器模式.VoltAdapter1;

/**
 * Created by pc on 2017/11/25.
 * 适配器模式：结构型模式，说到底就是将两个不兼容类融合到一起
 * <p>
 * 把一个类的接口变换成客户端所期待的另一种接口，从而使原本接口不匹配而无法工作在一起的两个类可以工作在一起。
 */

public class Test {

    public static void main(String[] args) {
        VoltAdapter1 adapter1 = new VoltAdapter1();
        System.err.println("1输出电压：" + adapter1.getVolt5());


        Volt220 adaptee = new Volt220();
        VoltAdapter2 adapter2 = new VoltAdapter2(adaptee);
        System.err.println("2输出电压：" + adapter2.getVolt5());
    }


}
