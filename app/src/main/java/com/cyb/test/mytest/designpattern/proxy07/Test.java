package com.cyb.test.mytest.designpattern.proxy07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by pc on 2017/9/20.
 * <p>
 * 代理模式：结构型，又叫委托模式
 * <p>
 * 定义：为其它对象提供一种代理以控制对这个对象的访问
 * 使用场景：当无法或不想直接访问某个对象,或者访问某个对象存在困难时可以通过一个代理对象间接访问，为了保证客户端使用的
 * 透明性，委托对象与代理对象需要实现相同的接口。
 * <p>
 * 角色一：目标接口  IService
 * 角色二：目标对象  单身汪 Jesse    == 委托对象？
 * 角色三：代理对象  老王       == 被委托对象？
 */
public class Test {
    public static void main(String[] args) {

        //静态代理
        IService iService1 = new ProxyLaoWang(new Jesse());
        iService1.findGirl("yw", 26);

        System.err.println("----------------");


        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //动态代理
        DynamicProxyCreater dynamicProxyCreater = new DynamicProxyCreater();
        final IService iService = new Jesse();
        IService dynamicProxy = dynamicProxyCreater.createServiceProxy(iService);
        dynamicProxy.findGirl("unknown", 18);

        System.err.println("----------------");

        $Proxy0 $Proxy0 = new $Proxy0(new InvocationHandler() {
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

        $Proxy0.findGirl("unknown1", 18);
        $Proxy0.findBoy("cyb");

        System.err.println("----------------");

//        IService jesse = dynamicProxyCreater.create(IService.class);
//        jesse.findGirl("girl", 12);
    }


}
