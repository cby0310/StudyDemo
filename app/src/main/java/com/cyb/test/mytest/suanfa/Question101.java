package com.cyb.test.mytest.suanfa;

public class Question101 {


    /**
     * @param array
     * @return
     */
    private static int getMaxMoney(int[] array) {
        int min = array[0];
        int money = 0;
        int outIndex = 0, lastInIndex = 0, inIndex = 0;

        for (int i = 1; i < array.length; i++) {


            if (array[i] - min > money) {
                outIndex = i;
                inIndex = lastInIndex;
                money = array[i] - min;
            }

            if (array[i] < min) {
                lastInIndex = i;
                min = array[i];
            }

        }

        System.err.println("inIndex = " + inIndex + ", outIndex = " + outIndex);

        return money;
    }

    /**
     * 股票利润最大
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {9, 11, 8, 50, 7, 12, 16, 140};
//        int[] array = {1,1,1,1,1};

        System.err.println("money = " + getMaxMoney(array));
    }
}
