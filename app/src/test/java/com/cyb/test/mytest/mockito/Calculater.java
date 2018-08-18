package com.cyb.test.mytest.mockito;

/**
 * Created by chaoyongbing on 2017/10/31 18:38.
 */

public class Calculater {

    IMathUtils mathUtils;

    public Calculater(IMathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    public double divide(int a, int b) {
        // 检测被除数是否为0
        if (mathUtils.checkZero(b)/*checkZero(b)*/) {
            throw new RuntimeException("dividend is zero");
        }

        return (double) a / b;
    }

    public boolean checkZero(int num) {
        return num == 0;
    }
}
