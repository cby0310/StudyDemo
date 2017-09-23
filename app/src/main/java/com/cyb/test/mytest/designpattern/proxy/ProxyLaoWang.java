package com.cyb.test.mytest.designpattern.proxy;

/**
 * Created by pc on 2017/9/20.
 * 代理对象：老王
 * 这是一个静态代理
 */

public class ProxyLaoWang implements IService {

    private IService iService;

    public ProxyLaoWang(IService iService) {
        this.iService = iService;
    }

    @Override
    public void findGirl(String name, int age) {
        /**
         * 老王替Jesse找到妹子之后告诉jesse
         */
        iService.findGirl(name, age);
    }
}
