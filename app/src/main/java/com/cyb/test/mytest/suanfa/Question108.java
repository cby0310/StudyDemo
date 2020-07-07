package com.cyb.test.mytest.suanfa;

import java.util.HashSet;

public class Question108 {

    /**
     * 求出字符全排列
     */
    private void allKinds(String str) {
        dfs(str.toCharArray(), 0);
    }


    private void dfs(char[] datas, int index) {
        if (index == datas.length - 1) {
            System.err.println(datas);
            return;
        }

        //交换的过程中若这位已经存在过某个字符则直接跳过
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = index; i < datas.length; i++) {
            if (hashSet.contains(datas[i])) {
                System.err.println(index + "  contains " + datas[i]);
                continue;
            } else {
                hashSet.add(datas[i]);
            }
            swap(datas, i, index);//交换，将 datas[i] 固定在第 index 位
            dfs(datas, index + 1); //固定下一位
            swap(datas, i, index);
        }
    }


    private void swap(char[] datas, int i, int j) {
        char tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }

    private void swap(int[] datas, int i, int j) {
        int tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }


    /**
     * 输入字符串"abc",则输出a、b、c、ab、ac、bc、abc 共7种组合。
     */
    private void allZuhe() {
        char[] chars = "aabc".toCharArray();

        for (int len = 1; len <= chars.length; len++) {
            combinate(chars, 0, len, new StringBuilder());
        }
    }


    private void combinate(char[] chars, int begin, int len, StringBuilder stringBuilder) {
        if (len == 0) {
            System.err.println(stringBuilder);
            return;
        }
        if (begin == chars.length) {
            return;
        }

        if(stringBuilder.toString().indexOf(chars[begin]) == -1){
            stringBuilder.append(chars[begin]);//取当前字符
            combinate(chars, begin + 1, len - 1, stringBuilder);

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            combinate(chars, begin + 1, len, stringBuilder);
        }

    }


    /**
     * 正方体全排列
     */
    private void zhengfangti() {
        int[] nums = new int[]{7, 7, 7, 70, 5, 5, 5, 5};
        dfs2(nums, 0);
        System.err.println("count = " + count);
    }


    private boolean isMatch(int[] nums) {
        return nums[0] + nums[1] + nums[2] + nums[3] == nums[4] + nums[5] + nums[6] + nums[7] &&
                nums[0] + nums[2] + nums[4] + nums[6] == nums[1] + nums[3] + nums[5] + nums[7] &&
                nums[0] + nums[1] + nums[4] + nums[5] == nums[2] + nums[3] + nums[6] + nums[7];
    }

    int count = 0;

    private void dfs2(int[] nums, int index) {
        if (index == nums.length - 1 && isMatch(nums)) {
            for (int i : nums) {
                System.err.print(i + " ");
            }
            System.err.println();
            count++;
            return;
        }

        HashSet hashSet = new HashSet();
        for (int i = index; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                continue;
            } else {
                hashSet.add(nums[i]);
            }

            swap(nums, i, index);//固定第index位
            dfs2(nums, index + 1);
            swap(nums, i, index);
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "abc";
        Question108 question108 = new Question108();
        question108.allKinds(str);
//
        System.err.println();
        question108.allZuhe();

//        question108.zhengfangti();
    }
}
