package com.cyb.test.mytest.designpattern.proxy.other;

/**
 * Created by pc on 2017/9/20.
 */

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("----- add -----");
    }
}