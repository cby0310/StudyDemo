package com.cyb.test.mytest.designpattern.proxy;

/**
 * Created by pc on 2017/9/20.
 * <p>
 * 代理模式：结构型
 *
 * 角色一：目标接口
 * 角色二：目标对象
 * 角色三：代理对象
 */
public class Test {
    public static void main(String[] args) {

        //静态代理
        ProxyLaoWang proxyLaoWang = new ProxyLaoWang(new Jesse());
        proxyLaoWang.findGirl("yw", 26);

        //动态代理
        DynamicProxyCreater dynamicProxyCreater = new DynamicProxyCreater();
        IService iService = new Jesse();
        IService dynamicProxy = dynamicProxyCreater.createServiceProxy(iService);
        dynamicProxy.findGirl("unknown", 18);


//        IService jesse = dynamicProxyCreater.create(IService.class);
//        jesse.findGirl("girl", 12);
    }


}
