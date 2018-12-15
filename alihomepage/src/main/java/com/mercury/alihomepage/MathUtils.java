package com.mercury.alihomepage;

/**
 * Created by mercury on 2017/12/15.
 */

public class MathUtils {

    public static int constrain(int amount, int low, int high) {
        int ret = amount < low ? low : amount;
        ret = ret > high ? high : ret;
        return ret;
    }

    public static float constrain(float amount, float low, float high) {
        float ret = amount < low ? low : amount;
        ret = ret > high ? high : ret;
        return ret;
    }
}
