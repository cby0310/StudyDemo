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


    /**
     * 输入字符串"abc",则输出a、b、c、ab、ac、bc、abc 共7种组合。
     */
    private void allZuhe() {
        char[] chars = "abc".toCharArray();

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
        stringBuilder.append(chars[begin]);//取当前字符
        combinate(chars, begin + 1, len - 1, stringBuilder);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        combinate(chars, begin + 1, len, stringBuilder);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "abc";
        Question108 question108 = new Question108();
        question108.allKinds(str);

        question108.allZuhe();
    }
}
