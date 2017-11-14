package com.cyb.test.mytest.designpattern.factory03.factorymethod.fansheshixian;

import com.cyb.test.mytest.designpattern.factory03.factorymethod.CarInterface;

/**
 * Created by pc on 2017/11/14.
 */

public abstract class Factory {
    public abstract <T extends CarInterface> T createCar(Class<T> tClass);
}
