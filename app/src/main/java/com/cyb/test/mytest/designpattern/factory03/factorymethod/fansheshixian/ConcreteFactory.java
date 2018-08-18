package com.cyb.test.mytest.designpattern.factory03.factorymethod.fansheshixian;

import com.cyb.test.mytest.designpattern.factory03.factorymethod.CarInterface;

/**
 * Created by pc on 2017/11/14.
 * 具体工厂类通过反射来实现，也可以像下面的一样一个一个工厂类的来写
 */

public class ConcreteFactory extends Factory {
    @Override
    public <T extends CarInterface> T createCar(Class<T> tClass) {
        T car = null;
        try {
            car = (T) Class.forName(tClass.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return car;
    }
}
