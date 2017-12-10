package com.cyb.test.mytest.shujujiegousuanfa;

/**
 * Created by pc on 2017/12/10.
 */

public class SortUtil {
    public static void swap(int[] datas, int i, int j) {
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    public static void printArray(int[] datas) {
        for (int i : datas) {
            System.err.print(i + "  ");
        }
        System.err.println();
    }


    //

}
