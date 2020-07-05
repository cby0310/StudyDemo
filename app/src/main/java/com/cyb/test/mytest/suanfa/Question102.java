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


    public int cutRope(int target) {
        //排除特殊情况
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        products[4] = 4;
        for (int i = 5; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                max = Math.max(max, product);
            }
            products[i] = max;
        }
        return products[target];
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
        System.err.println("getMaxProduct = " + question102.cutRope(10));

        System.err.println(Math.pow(2.0,-2147483648));
    }
}
