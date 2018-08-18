package com.cyb.test.mytest.designpattern.singleton01;

/**
 * Created by pc on 2017/10/24.
 * 枚举单例实现
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是一个单例
 * 根据枚举实现原理可知，INSTANCE为一个Singleton常量，虚拟机会保证<clinit>()类方法的线程安全，另外反序列化是通过valueOf("")方法，单例会在内存缓存
 */

public class MeiJuSingleton {


    private MeiJuSingleton() {
    }

    public static MeiJuSingleton getInstance() {
        Singleton.valueOf("");
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private MeiJuSingleton instance;

        Singleton() {
            instance = new MeiJuSingleton();
        }

        public MeiJuSingleton getInstance() {
            return instance;
        }
    }
}


