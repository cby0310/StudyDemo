package com.cyb.test.mytest.suanfa;

public class Question102 {


    private int getMaxProduct(int length) {
        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        int max = getMaxProductCore(length);
        return max;
    }


    private int getMaxProductCore(int length) {
        if (length < 4) {
            return length;
        }
        int max = 0;
        for (int i = 1; i < length; i++) {
            int temp = (getMaxProductCore(i) * getMaxProductCore(length - i));
//            System.err.println("temp = " + temp);
            max = Math.max(temp, max);
        }

        return max;

    }

    /**
     * 剪绳子，长为n的绳子剪成m段，怎么剪能使每段的乘积最大，最大乘积是多少
     *
     * @param args
     */
    public static void main(String[] args) {
        Question102 question102 = new Question102();
        System.err.println("getMaxProduct = " + question102.getMaxProduct(8));
    }
}
