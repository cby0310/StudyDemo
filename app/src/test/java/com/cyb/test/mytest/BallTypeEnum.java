package com.cyb.test.mytest;

/**
 * Created by chaoyongbing on 2017/11/10 9:26.
 */

public enum BallTypeEnum {
    BASKETBALL(100),
    PINGPANGBAL(5);

    private int price;

    BallTypeEnum(int price) {
        this.price = price;

        Status status = new Status();
//        status.START.START.START;
        Status status1 = status.RUNNING.STOP.START;
    }
}
