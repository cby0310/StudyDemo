package com.cyb.test.mytest.designpattern.proxy07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pc on 2017/9/20.
 * <p>
 * 动态代理
 */

public class DynamicProxyCreater {

    public <T> T create(Class<T> cls) {
        return (T) Proxy.newProxyInstance(
                cls.getClassLoader(),
                new Class<?>[]{cls},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long timeBegin = System.currentTimeMillis();
                        Object obj = method.invoke(this, args);
                        long timeEnd = System.currentTimeMillis();
                        System.err.println(method.getName() + "花费时间：" + (timeEnd - timeBegin) + "ms");
                        return obj;
                    }
                });
    }

    public IService createServiceProxy(final IService iService) {
        return (IService) Proxy.newProxyInstance(
                iService.getClass().getClassLoader(),
                iService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.err.println("method ：" + method.toString() + "  args : " + args);
                        long timeBegin = System.currentTimeMillis();
                        Object obj = method.invoke(iService, args);
                        long timeEnd = System.currentTimeMillis();
                        System.err.println(method.getName() + "花费时间：" + (timeEnd - timeBegin) + "ms");
                        return obj;
                    }
                });
    }

}
