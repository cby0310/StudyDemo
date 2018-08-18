package com.cyb.test.mytest.designpattern.singleton01;

import java.io.ObjectStreamException;

/**
 * Created by pc on 2017/10/24.
 * 静态内部类单例
 */

public class JingTaiNeiBuLeiSingleton {
    private JingTaiNeiBuLeiSingleton() {
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final JingTaiNeiBuLeiSingleton instance = new JingTaiNeiBuLeiSingleton();
    }


    public static JingTaiNeiBuLeiSingleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 反序列化提供的一个很特别的钩子函数，加入了这个方式才能保证反序列化时也是单例
     *
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return SingletonHolder.instance;
    }
}
