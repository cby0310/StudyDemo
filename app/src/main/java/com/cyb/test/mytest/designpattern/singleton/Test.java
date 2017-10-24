package com.cyb.test.mytest.designpattern.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/10/24.
 * 单例模式,若需要引用context则使用ApplicationContext，防止内存泄露
 * 1.构造函数私有化
 * 2.通过一个静态方法或者枚举返回单例类对象
 * 3.确保对象只有一个，特别是多线程模式下
 * 4.确保单例在反序列化时不会重新构造对象
 */

public class Test {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();

        EHanSingleton eHanSingleton1 = EHanSingleton.getInstance();
        EHanSingleton eHanSingleton2 = EHanSingleton.getInstance();
        objects.add(eHanSingleton1);
        objects.add(eHanSingleton2);

        LanHanSingleton lanHanSingleton1 = LanHanSingleton.getInstance();
        LanHanSingleton lanHanSingleton2 = LanHanSingleton.getInstance();
        objects.add(lanHanSingleton1);
        objects.add(lanHanSingleton2);

        JingTaiNeiBuLeiSingleton jingTaiNeiBuLeiSingleton1 = JingTaiNeiBuLeiSingleton.getInstance();
        JingTaiNeiBuLeiSingleton jingTaiNeiBuLeiSingleton2 = JingTaiNeiBuLeiSingleton.getInstance();
        objects.add(jingTaiNeiBuLeiSingleton1);
        objects.add(jingTaiNeiBuLeiSingleton2);

        Resource meiJuSingleton1 = MeiJuSingleton.INSTANCE.getInstance();
        Resource meiJuSingleton2 = MeiJuSingleton.INSTANCE.getInstance();
        objects.add(meiJuSingleton1);
        objects.add(meiJuSingleton2);


        MapSingleton.registerService("resource", new Resource());
        Resource mapSingleton1 = (Resource) MapSingleton.getInstence("resource");
        Resource mapSingleton2 = (Resource) MapSingleton.getInstence("resource");
        objects.add(mapSingleton1);
        objects.add(mapSingleton2);


        for (Object o : objects) {
            System.err.println(o.toString());
        }

    }
}
