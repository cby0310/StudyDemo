package com.cyb.test.mytest.suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Question35 {
    /**
     * 输入一个字符串，输出其第一个只出现一次的字符
     * 维护一个链式哈希，以字符为 key 出现次数为 value,每出现一次 value+1
     * 最后返回链表中第一个值为 1 的字符（key）
     *
     * @param str
     * @return
     */
    public char firstNotRepeatChar(String str) {
        if (str == null) {
            return '\0';
        }
        // 这里假如用HashMap，则最后需要遍历str的字符从hashMap逐一取出判断，
        // LinkedHashMap是去重的，又是按照插入顺序存储的，它的长度肯定小于str的长度，所以效率更高些
        HashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (Character c : hashMap.keySet()) {
            if (hashMap.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }


    /**
     * 输入两个字符串，从第一个字符串中删除第二个字符串中的所有字符(详解)
     *
     * @param source
     * @param target
     * @return
     */
    private String delTargetChars(String source, String target) {

        HashMap<Character, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            hashMap.put(target.charAt(i), true);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < source.length(); j++) {
            if (hashMap.get(source.charAt(j)) == null || !hashMap.get(source.charAt(j))) {
                stringBuilder.append(source.charAt(j));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Question35 q = new Question35();
        System.out.println(q.firstNotRepeatChar("gabgaccdeff"));

        System.err.print(q.delTargetChars("They are students", "aeiou"));
    }
}
