package com.cyb.test.mytest.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Question116 {


    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * <p>
     * 返回的长度需要从小到大排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diving-board-lcci
     *
     * @param args
     */
    public static void main(String[] args) {
        Question116 question116 = new Question116();
        question116.divingBoard(4, 12, 10);


        int[] nums = new int[]{3, 30, 34, 9, 5};
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return -(s1 + s2).compareTo(s2 + s1);
            }
        });

        System.err.print(strs);
    }


    ArrayList<Integer> res = new ArrayList();
    int sum = 0;

    public int[] divingBoard(int shorter, int longer, int k) {
        if (0 == k) {
            return new int[0];
        }

//        if (shorter == longer) {
//            return new int[]{shorter * k};
//        }

        dfs(shorter, longer, k, 0);

        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
            System.err.print(a[i] + ",");
        }
        return a;
    }

    public void dfs(int shorter, int longer, int k, int index) {
        if (index == k) {
            if (!res.contains(sum))
                res.add(sum);
            return;
        }

        //这里只可能有两种取值，长或者短，不用for循环
//        for (int i = 1; i < 2; i++) {
        sum += shorter;//第i位选短的
        dfs(shorter, longer, k, index + 1);

        sum -= shorter;//第i位选长的
        sum += longer;
        dfs(shorter, longer, k, index + 1);
        sum -= longer;
//        }
    }


}
