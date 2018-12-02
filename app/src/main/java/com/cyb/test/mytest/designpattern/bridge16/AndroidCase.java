package com.cyb.test.mytest.designpattern.bridge16;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class AndroidCase extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        在framework中，Window和PhoneWindow构成UML中抽象部分，WindowManager和WindowManagerImpl构成实现部分
//        WindowManagerImpl使用WindowManagerGlobal通过IWindowManager接口和WMS进行交互，并由WMS完成具体的窗口工作
//        具体来讲，通过IWindowManager接口的openSession方法得到IWindowSession对象，然后就在ViewRootImpl中调用IWindowSession的addToDisplay、remove
//        等方法请求WMS添加或者移除window等
    }
}
