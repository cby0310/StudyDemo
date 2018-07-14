package com.cyb.test.mytest.shujujiegousuanfa;

/**
 * Created by pc on 2017/12/10.
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] datas = new int[]{1, 3, 2, 3, 2, 13, 44};
        selectSort(datas);
        SortUtil.printArray(datas);

        System.gc();
    }

    /**
     * 选择排序，记录最小下标和最前面的交换
     * 例如：5 8 5 2 9 是不稳定型排序
     * 时间复杂度 O(n^2)
     *
     * @param datas
     */
    private static void selectSort(int[] datas) {
        int length = datas.length;
        int minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (datas[j] < datas[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortUtil.swap(datas, minIndex, i);
            }
        }
    }
}
