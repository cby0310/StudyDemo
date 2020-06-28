package com.cyb.test.mytest.suanfa;

import java.util.Arrays;

public class Question44 {
    /**
     * 题目：从扑克牌中随机抽取 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
     * 2~10 为数字本身，A 为 1，Q 为 12，K 为 13,大王小王可以为任意数字（0）
     * 特殊情况：出现对子一定不为顺子
     *
     * @param nums
     * @return
     */
    public boolean isContinuous(int[] nums) {
        Arrays.sort(nums);
        int countZero = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[nums.length - 1] - nums[countZero] < 5;//最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {
        Question44 q = new Question44();
        int[] nums = {6, 0, 1, 2, 3};
        System.out.println(q.isContinuous(nums));
    }
}
