package com.cyb.test.mytest.designpattern.singleton01;

import java.io.ObjectStreamException;

/**
 * Created by pc on 2017/10/24.
 * 懒汉式单例DCL，双重检查锁
 */

public class LanHanSingleton {
    //1.防止指令重排序   2.线程可见性，修改了立即写进主存
    private static volatile LanHanSingleton instance = null;

    private LanHanSingleton() {
    }

    public static LanHanSingleton getInstance() {
        if (instance == null) {//避免不必要的同步
            synchronized (LanHanSingleton.class) {
                if (instance == null) {//在null的情况下同步
                    //这一步其实有3步：
                    //1.给LanHanSingleton的实例分配内存
                    //2.调用LanHanSingleton()的构造函数，初始化成员字段
                    //3.将instance对象指向分配的内存空间
                    //但是Java编译器允许指令重排序，若第一个线程执行书序为1-3-2，切换到了第二个线程，
                    //判断不为null就拿去了instance，而此时instance指向的内存区域还未初始化就发生了错误
                    //加入volatile关键字就解决了这个问题
                    instance = new LanHanSingleton();
                }
            }
        }

        return instance;
    }

    /**
     * 反序列化提供的一个很特别的钩子函数，加入了这个方式才能保证反序列化时也是单例
     *
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
