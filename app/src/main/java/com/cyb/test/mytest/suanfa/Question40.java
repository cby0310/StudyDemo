package com.cyb.test.mytest.suanfa;

import java.util.Arrays;

public class Question40 {
    /**
     * 异或特性，A^A 异或得 0，A^B 二进制至少有 1 位为 1
     * 同则为 0 ，异则为 1
     * 问题：输入数组，其中只有 1 个数出现 1 次，其余所有数都出现 2 次，求该只出现 1 次的数
     *
     * @param nums
     * @return
     */
    public int findNumAppearOnce(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * 问题：输入数组，其中只有 2 个数出现 1 次，其余所有数都出现 2 次，求只出现 1 次的两个数
     * * 借鉴找 1 个只出现 1 次数的思路，将 1 个数组分为两个，分别包含 1 个只出现 1 次的数字
     * * 如何划分数组？ —— 异或特性，两个数不同 A^B 二进制至少有 1 位为 1，求出数组异或结果，求出二进制第一个 1 出现位置
     * * 根据二进制位数不同划分数组
     *
     * @param nums
     * @return
     */
    public int[] findNumsAppearOnce(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        //存放两个只出现一次的数的异或结果
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        int n = getBinaryBitFirst1Index(result); // 记录二进制第一个 1 的位置(从右往左以0开始数)

        String binaryNum = Integer.toBinaryString(result);
        System.out.println("result = " + result + "，binaryNum = " + binaryNum + "，n = " + n);

        int[] results = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (isBinaryBitSame(nums[i], n)) {
                results[0] ^= nums[i];
            } else {
                results[1] ^= nums[i];
            }
        }
        return results;
    }

    private int getBinaryBitFirst1Index(int num) {

        int index = 0;
        while ((num & (1 << index)) == 0 && index < 8 * 4) {
            index++;
        }

        return index;
    }

    /**
     * num的二进制从右往左0开始数是不是1
     *
     * @param num
     * @param n
     * @return
     */
    private boolean isBinaryBitSame(int num, int n) {
        return (num & (1 << n)) != 0;
    }


    /***
     *一个数组中只有一个数出现了一次，其他都出现了三次，求出这个数
     * @param nums
     * @return
     */
    private int getOnlyOneNumber(int[] nums) {

        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += ((nums[i] & (1 << j)) != 0) ? 1 : 0;
            }
        }

        int result = 0;
        for (int k = 0; k < bits.length; k++) {
            result += (bits[k] % 3) * (1 << k);
        }

        return result;
    }

    /**
     *
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 3, 61, 3, 2, 5, 5};
        Question40 q = new Question40();
//        System.out.println(q.isBinaryBitSame(1, 0));
        System.out.println(Arrays.toString(q.findNumsAppearOnce(nums)));

        System.err.println(q.getOnlyOneNumber(new int[]{1, 2, 2, 1, 2, 98, 3, 1, 3, 3}));
    }
}
