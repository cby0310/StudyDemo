package com.cyb.test.mytest.designpattern.proxy07.dynamicproxy;

/**
 * Created by pc on 2017/9/20.
 */

public class UserServiceImpl implements UserService {

    @Override
    public boolean add() {
        System.out.println("----- add -----");
        return true;
    }
}