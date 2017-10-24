package com.cyb.test.mytest.designpattern.singleton;

/**
 * Created by pc on 2017/10/24.
 * 枚举单例实现
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是一个单例
 */

class Resource {
}

public enum MeiJuSingleton {

    INSTANCE;

    private Resource instance;

    MeiJuSingleton() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }

}
