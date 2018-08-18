package com.cyb.test.mytest.shujujiegousuanfa;

/**
 * Created by pc on 2017/12/10.
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4, 5, 6, 44};//等于int[] var1 = new int[]{1, 2, 3, 4, 5, 6, 44};
        bubbleSortOpt(datas);
        SortUtil.printArray(datas);
    }

    /**
     * 冒泡排序，大的往后冒
     * 稳定型排序，时间复杂度（n-1）+（n-2）+...+1 = n^2/2  即为 O(n^2)
     *
     * @param datas
     */
    private static void bubbleSort(int[] datas) {
        int swapCount = 0;
        int compareCount = 0;

        int length = datas.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                compareCount++;
                if (datas[j] > datas[j + 1]) {
                    swapCount++;
                    SortUtil.swap(datas, j, j + 1);
                }
            }
        }

        System.err.println("对比次数：" + compareCount);
        System.err.println("交换次数：" + swapCount);
    }

    /**
     * 冒泡排序优化，记录是否交换了来确实是否已经有序了
     * 已经有序则无需再继续比较了
     *
     * @param datas
     */
    private static void bubbleSortOpt(int[] datas) {
        int swapCount = 0;
        int compareCount = 0;

        int length = datas.length;
        boolean flag = true;//初始值认为无序
        for (int i = 0; flag && i < length - 1; i++) {
            flag = false;//每一轮开始时设为false，假设有序
            for (int j = 0; j < length - 1 - i; j++) {
                compareCount++;
                if (datas[j] > datas[j + 1]) {
                    SortUtil.swap(datas, j, j + 1);
                    flag = true;//交换了证明是无序的
                    swapCount++;
                }
            }
        }

        System.err.println("对比次数：" + compareCount);
        System.err.println("交换次数：" + swapCount);
    }
}
