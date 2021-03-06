package com.cyb.test.mytest.designpattern.iterator18;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 迭代器模式，又称游标cursor模式
 * 例如List，Map的遍历
 * 查询数据库也是迭代器模式
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.err.println(item);
        }
    }
}
