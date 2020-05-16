package com.cyb.test.mytest.designpattern.singleton01;

/**
 * Created by pc on 2017/10/24.
 * 枚举单例实现
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是一个单例
 * 根据枚举实现原理可知，INSTANCE为一个Singleton常量，虚拟机会保证<clinit>()类方法的线程安全，另外反序列化是通过valueOf("name")方法获取实例，valueOf最终
 * 会通过反射拿到$VALUES数组，然后根据name匹配到对象。一个进程中只有一个INSTANCE对象，所以是单例。
 */

public class MeiJuSingleton {


    private MeiJuSingleton() {
    }

    public static MeiJuSingleton getInstance() {
        Singleton.valueOf("INSTANCE");
        return Singleton1.INSTANCE.getInstance();
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

    static final class Singleton1 extends Enum<Singleton1> {

        public static final Singleton1 INSTANCE;
        public static final Singleton1 $VALUES[];

        static {
            INSTANCE = new Singleton1("INSTANCE", 0);
            $VALUES = new Singleton1[]{
                    INSTANCE
            };
        }

        public static Singleton1[] values() {
            return $VALUES;
        }

        public static Singleton1 valueOf(String s) {
            return Enum.valueOf(Singleton1.class, s);
        }

        private MeiJuSingleton instance;

        protected Singleton1(String name, int ordinal) {
            super(name, ordinal);
            instance = new MeiJuSingleton();
        }


        public MeiJuSingleton getInstance() {
            return instance;
        }

    }

}


