package com.cyb.test.mytest.designpattern.proxy.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pc on 2017/9/20.
 */

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
//        System.out.println("----- before -----");
//        Object result = method.invoke(target, args);
//        System.out.println("----- after -----");

        long timeBegin = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long timeEnd = System.currentTimeMillis();
        System.err.print(method.getName() + "花费时间：" + (timeEnd - timeBegin) + "ms");

        return result;
    }
}
