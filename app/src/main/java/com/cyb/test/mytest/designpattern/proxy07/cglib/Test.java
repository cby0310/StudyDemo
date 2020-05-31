package com.cyb.test.mytest.designpattern.proxy07.cglib;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
public class Test {

    public static void main(String[] args) {

        //代理类class文件存入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/cyb/android/bytedance/StudyDemo/app/src/main/java/com/cyb/test/mytest/designpattern/proxy07/cglib/class");

        Programmer progammer = new Programmer();

        Hacker hacker = new Hacker();

        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(progammer.getClass());
        // 设置回调，这里se相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(hacker);

        Programmer proxy =(Programmer)enhancer.create();
        proxy.code();

        System.out.println("----------");
        System.out.println(proxy.getClass().getName());
    }
}
