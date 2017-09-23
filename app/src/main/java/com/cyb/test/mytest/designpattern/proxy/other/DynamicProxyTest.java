package com.cyb.test.mytest.designpattern.proxy.other;

/**
 * Created by pc on 2017/9/20.
 */

public class DynamicProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
    }
}
