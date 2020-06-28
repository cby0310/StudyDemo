package com.cyb.test.mytest.suanfa;

public class Question109 {

    int count = 0;
    int A = 0 - 'a';

    /**
     * 深度优先遍历找出所有解
     *
     * @param nums
     * @param index
     * @param stringBuilder
     */
    private void dfs(char[] nums, int index, StringBuilder stringBuilder) {
        if (index == nums.length) {
            count++;
            System.err.print(stringBuilder.toString() + " > ");
            String[] strings = stringBuilder.toString().split(",");
            for (String s : strings) {
                int v = Integer.parseInt(s);
                System.err.print((char) (v - A) + "");
            }
            System.err.println();
            return;
        }

        stringBuilder.append(nums[index] + ",");
        //选择单独一个字符
        dfs(nums, index + 1, stringBuilder);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        //判断是否可以选择两个
        if (index + 1 < nums.length) {
            int temp = Integer.parseInt(nums[index] + "") * 10 + Integer.parseInt(nums[index + 1] + "");
            if (temp >= 10 && temp <= 25) {
                stringBuilder.append((temp < 10 ? "0" + temp : temp) + ",");
                //选择两个连续字符
                dfs(nums, index + 2, stringBuilder);

                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            }
        }
    }


    /**
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
     *
     * @param num
     * @return
     */
    private int getTranslateNum(int num) {
        //a:f(i-1)  b:f(i-2)
        int a = 1, b = 1;
        String numStr = num + "";
        for (int i = 2; i <= numStr.length(); i++) {
            String temp = numStr.substring(i - 2, i);
            //求的f(i)
            int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }

        return a;
    }


    public int getTranslateNum2(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    /**
     * 把数字翻译成字符串，求次数
     * 12258有5种翻译
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 8;
        Question109 question109 = new Question109();
        question109.dfs((num + "").toCharArray(), 0, new StringBuilder());
        System.err.println(question109.count);
        System.err.println();
        System.err.println(question109.getTranslateNum(num));
        System.err.println(question109.getTranslateNum2(num));

    }
}
