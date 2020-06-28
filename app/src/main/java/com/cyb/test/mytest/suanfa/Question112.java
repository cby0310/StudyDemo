package com.cyb.test.mytest.suanfa;

public class Question112 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Question112 question112 = new Question112();
        question112.question1();
        question112.question2();
    }


    /**
     * 在排序数组中查找数字,统计一个数字在排序数组中出现的次数。
     */
    private void question1() {
        int[] nums = {5, 7, 7, 7, 8, 8, 8, 8, 8, 10};
        int target = 8;
        //找出target右边界
        int indexRight = halfSearch(nums, target);
        int indexLeft = halfSearch(nums, target - 1);
        System.err.println(indexRight + " " + indexLeft);
    }


    /**
     * 0~n中缺失的数字
     * 转换为查找第一个值和下标不相等的数字
     */
    private void question2() {
        int[] nums = {0, 1, 3, 4, 5, 6, 7};

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mid != nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.err.println(left);
    }


    private int halfSearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
