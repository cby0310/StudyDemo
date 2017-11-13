package com.cyb.test.mytest.designpattern.singleton01;

/**
 * Created by pc on 2017/10/24.
 * 枚举单例实现
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是一个单例
 */

public class MeiJuSingleton {


    private MeiJuSingleton() {
    }

    public static MeiJuSingleton getInstance() {
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


