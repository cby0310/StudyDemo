package com.cyb.test.mytest.mockito;

/**
 * Created by chaoyongbing on 2017/10/31 18:48.
 */

public class IMathUtilsTest implements IMathUtils {
    @Override
    public int abs(int num) {
        return 0;
    }

    @Override
    public boolean checkZero(int num) {
        return num == 0;
    }
}
