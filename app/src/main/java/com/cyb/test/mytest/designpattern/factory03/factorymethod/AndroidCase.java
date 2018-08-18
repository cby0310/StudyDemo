package com.cyb.test.mytest.designpattern.factory03.factorymethod;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by pc on 2017/11/16.
 */

public class AndroidCase extends Activity {

    //onCreate也可以看做是一个工厂方法，整个Activity相当于工厂，我们可以在onCreate方法中
    //生产出不同的view（产品）进行展示
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Iterator相当于产品，ArrayList和HashSet相当于工厂，具体的Iterator在工厂内有不同的具体实现，这就是工厂模式的运用
        ArrayList<String> list = new ArrayList<String>();
        Iterator<String> iterator = list.iterator();

        HashSet<String> hashSet = new HashSet<>();
        Iterator<String> iterator1 = hashSet.iterator();


    }
}
