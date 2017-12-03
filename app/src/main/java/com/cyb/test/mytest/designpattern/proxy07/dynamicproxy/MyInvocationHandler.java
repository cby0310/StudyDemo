package com.cyb.test.mytest.designpattern.proxy07.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.internal.platform.Platform;

/**
 * Created by pc on 2017/9/20.
 */

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }


    public static <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    private final Platform platform = Platform.get();

                    @Override
                    public Object invoke(Object proxy, Method method, Object... args)
                            throws Throwable {
                        System.err.println("sssssssssss");
                        return null;
                    }
                });
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
