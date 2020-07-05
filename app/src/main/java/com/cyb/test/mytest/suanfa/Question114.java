package com.cyb.test.mytest.suanfa;

public class Question114 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Question114 question114 = new Question114();
        System.err.println(question114.myPow(2.0, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (x == 1 || n == 0) {
            return 1;
        }

        long nL = n;
        double result = pow(x, nL > 0 ? nL : -nL);
        return nL > 0 ? result : 1.0 / result;
    }

    public double pow2(double x, long n) {
        if (n == 1) {
            return x;
        }

        double r = pow2(x, n >> 1);
        r *= r;

        if ((n & 1) != 0) { //奇数
            r *= x;
        }
        return r;
    }

    public double pow(double x, long n) {
        double r = 1;

        while (n > 0) {
            if ((n & 1) == 1) r *= x;
            x *= x;
            n >>= 1;
        }

        return r;
    }

}
