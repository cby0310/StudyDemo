package com.cyb.test.mytest.designpattern.proxy07.dynamicproxy;

/**
 * Created by pc on 2017/9/20.
 */

public class DynamicProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        UserService proxy = (UserService) invocationHandler.getProxy();
        UserService p2 = MyInvocationHandler.create(UserService.class);
//        proxy.add();
        p2.add();
    }
}
