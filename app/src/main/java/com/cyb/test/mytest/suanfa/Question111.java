package com.cyb.test.mytest.suanfa;

import java.util.HashMap;
import java.util.Map;

public class Question111 {


    /**
     * 最长不含重复字符的子字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "arabcacfr";
        Question111 question111 = new Question111();
        System.err.println(question111.getMaxLengthSubStr2(str));

        System.err.println(question111.reverse(1534236469));

    }

    public int reverse(int x) {
        long sum = 0;

        while (Math.abs(x) > 0) {
            int a = x % 10;
            sum = sum * 10 + a;
            x = x / 10;
        }

        return (int) sum == sum ? (int) sum : 0;
    }

    private int getMaxLengthSubStr(String str) {

        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }

        int left = 0, right = 0;
        int maxLength = 1;

        //存放字符和下标的映射
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                left = map.get(str.charAt(i)) + 1;
                for (int j = 0; j < left; j++) {
                    map.remove(str.charAt(j));
                }
            }

            right = i;
            map.put(str.charAt(i), i);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    private int getMaxLengthSubStr2(String str) {

        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }

        int left = 0;
        int maxLength = 1;

        //存放字符和下标的映射
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                //left只能往前走
                left = Math.max(left, map.get(str.charAt(i)));
            }

            map.put(str.charAt(i), i);
            maxLength = Math.max(maxLength, i - left);
        }

        return maxLength;
    }

}
