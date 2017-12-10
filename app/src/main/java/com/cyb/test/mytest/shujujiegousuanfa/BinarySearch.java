package com.cyb.test.mytest.shujujiegousuanfa;

/**
 * Created by pc on 2017/12/10.
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] datas = {1, 2, 3, 4, 5, 6, 7};//等于int[] var1 = new int[]{1, 2, 3, 4, 5, 6, 44};
//        int index = binarySearch1(datas, 7);
        int index = binarySearch2(datas, 0, datas.length - 1, 17);
        System.err.println(index);
    }


    /**
     * 折半查找，两个指针控制首尾向中间搜查
     * <p>
     * 时间复杂度
     * 比如：总共有n个元素，每次查找的区间大小就是n，n/2，n/4，…，n/2^k（接下来操作元素的剩余个数），其中k就是循环的次数。
     * 由于n/2^k取整后>=1，即令n/2^k=1，
     * 可得k=log2n,（是以2为底，n的对数），所以时间复杂度可以表示O()=O(logn)
     *
     * @param datas
     * @param des
     * @return
     */
    public static int binarySearch1(int[] datas, int des) {
        int length = datas.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {//等号是防止要找的正好是第一个或者最后一个的情况
            int middle = (low + high) / 2;
            if (des == datas[middle]) {
                return middle;
            } else if (des > datas[middle]) {
                low = middle + 1;//记得 +1 和下面的需要 -1
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 递归 折半查找
     *
     * @param datas
     * @param des
     * @return
     */
    public static int binarySearch2(int[] datas, int low, int high, int des) {
        if (low <= high) {
            int middle = (low + high) / 2;
            if (datas[middle] == des) {//只有相等的时返回，否则一直缩小范围，直到low < high
                return middle;
            } else if (datas[middle] > des) {
                return binarySearch2(datas, low, middle - 1, des);
            } else {
                return binarySearch2(datas, middle + 1, high, des);
            }
        } else {
            return -1;
        }
    }
}
