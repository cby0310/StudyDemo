package com.cyb.test.mytest.designpattern.factory03.simplefactory;

/**
 * Created by pc on 2017/9/24.
 */

public class CarFactory {

    public static CarInterface createCar(CarType carType) {
        CarInterface car = null;
        switch (carType) {
            case BENZ:
                car = new Benz();
                break;
            case BYD:
                car = new Byd();
                break;
            case BMW:
                car = new Bmw();
                break;
        }
        return car;
    }

}
