package com.cyb.test.mytest.suanfa;

import java.util.Arrays;

public class Question51 {
    /**
     * 题：在一个长度为 n 的数组中，所有的数字都在 0~n-1 的范围内。数组中的某些数字是重复的，但不知有几个数重复，也不知道数字重复了几次。
     * 找出数组中任意重复的数字。
     * 解题思路：从题目中找到规律，数组长度为 n，且所有数字都在在 0~n-1 的范围内,数组下标和值形成了对应关系
     * 一次遍历，每遍历一数将其放到对应下标，若已存在相同数则返回当前遍历数
     *
     * @param nums
     * @return
     */
    public int duplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int i = 0;
        while (i < nums.length) {
            if (i != nums[i] && nums[i] == nums[nums[i]]) { // 对应下标已有对应数，说明当前遍历数为重复数
                return nums[i];
            } else if (nums[nums[i]] != nums[i]) { // 将数放置对应下标位置，索引值不变
                swap(nums, i, nums[i]);
            } else { // nums[nums[i]] = nums[i] 位置正确，遍历下一数
                i++;
            }
        }
        return -1;
    }

    /**
     * 题：在一个长度为 n 的数组中，所有的数字都在 0~n-1 的范围内。数组中的某些数字是重复的，但不知有几个数重复，也不知道数字重复了几次。
     * 找出数组中任意重复的数字。
     * 解题思路：从题目中找到规律，数组长度为 n，且所有数字都在在 0~n-1 的范围内,数组下标和值形成了对应关系
     * 一次遍历，每遍历一数将其放到对应下标，若已存在相同数则返回当前遍历数
     * 长度 8
     * {3,1,4,5,6,7,1,2}
     *
     * @param nums
     * @return
     */
    private int get(int[] nums) {

        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index) {
                index++;
            } else {
                if (nums[index] == nums[nums[index]]) {
                    return nums[index];
                }
                swap(nums, index, nums[index]);
            }
        }

        return -1;
    }


    /**
     * 在一个长度为n+1的数组里的所有数字都在1~n范围内，所以数组中至少有一个是重复的，不能修改数组找到它
     * 不修改数组找出重复的数字
     * 二分查找法
     * {2, 3, 5, 4, 3, 2, 6, 7}  答案： 2 or 3
     *
     * @param nums
     * @return
     */
    private int get1(int[] nums) {

        if (nums.length <= 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums.length) {
                return -1;
            }
        }

        int start = 1;
        int end = nums.length;

        int middle = (start + end) >> 1;
        int leftHitCount;

        while (middle >= start) {

            leftHitCount = getCount(nums, start, middle); //1~m命中的数量
            if (leftHitCount > middle - start + 1) { //在左边
                if (middle == start) {
                    return start;
                }
                end = middle;
            } else {//在右边
                if (middle == start) {
                    return end;
                }
                start = middle + 1;
            }

            middle = (start + end) >> 1;

        }

        return -1;
    }

    /**
     * 找出大小处于之间的数字的数量
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int getCount(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Question51 q = new Question51();
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(q.get1(nums));
        System.out.println(Arrays.toString(nums)); // 检测数组是否放置正确
    }
}
