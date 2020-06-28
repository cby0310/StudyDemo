package com.cyb.test.mytest.suanfa;

import java.util.Arrays;

public class Question36 {
    /**
     * 问题：统计字符串中的逆序对数
     * 通过归并排序的思路统计逆序对数
     *
     * @param nums
     * @return
     */
    public int countInversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int count = mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    /**
     * 6.归并排序  最差、平均、最好：O(n log n) ，稳定
     * 将数组分为一各个小块，对每一块进行排序再合并
     *
     * @param nums
     */
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int middle = start + ((end - start) >>> 1);
        int c1 = mergeSort(nums, start, middle); //左半部分排序
        int c2 = mergeSort(nums, middle + 1, end);//右半部分排序

        //这俩部分已经有序，此时不需要再次合并
        if (nums[middle] <= nums[middle + 1]) {
            return c1 + c2;
        }

        return merge(nums, start, middle, end) + c1 + c2; //合并两个有序的部分
    }


    /**
     * 合并两个有序数组
     */
    private int merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];//申请临时数组进行合并
        int i = 0;
        int p1 = start;
        int p2 = mid + 1;
        int reverseCount = 0;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= end) {

            if (nums[p2] < nums[p1]) { // 取了右边的
                reverseCount += (mid - p1 + 1);
                for (int t = p1; t <= mid; t++) {
                    System.err.print("(" + nums[t] + "," + nums[p2] + ")");
                }
                System.err.println("reverseCount = " + reverseCount);
            }

            temp[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }

        while (p2 <= end) {
            temp[i++] = nums[p2++];
        }

        // 把最终的排序的结果复制给原数组
        for (int j = 0; j < temp.length; j++) {
            nums[start + j] = temp[j];
        }

        return reverseCount;
    }

    public static void main(String[] args) {
        Question36 q = new Question36();
        int[] nums = {3, 6, 9, 7, 4, 5, 12};
        System.out.println(q.countInversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

}
