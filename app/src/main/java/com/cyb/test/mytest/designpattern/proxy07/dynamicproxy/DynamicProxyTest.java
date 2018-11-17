package com.cyb.test.mytest.designpattern.proxy07.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pc on 2017/9/20.
 */

public class DynamicProxyTest {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        //1.执行对指定类对象的hook
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        System.err.println(proxy.add());
        System.err.println("------------");

        //2.直接传进去接口的class类型，执行对interface方法的hook，retrofit就是这么做的
        UserService p2 = create(UserService.class);
        p2.add();
//        报错：java.lang.ClassCastException: java.lang.Boolean cannot be cast to java.lang.String
//        System.err.println(p2.toString());
    }


    public static <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object... args) {
//                        System.err.println("proxy:" + proxy);
//                        System.err.println("args:"+args);
                        System.err.println("method = " + method.getName());
                        return true;
                    }
                });
    }
}
