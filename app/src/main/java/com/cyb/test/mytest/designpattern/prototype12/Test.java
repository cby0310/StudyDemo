package com.cyb.test.mytest.designpattern.prototype12;

import android.content.Intent;

import java.util.ArrayList;

/**
 * 原型模式，"原型"二字表明了有一个样版实例，用户可以从这个对象中复制出一个内部属性一致的对象，可用于保护性拷贝
 * 用于创建重复的对象，就是克隆，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 浅度/深度拷贝，深度拷贝时引用类型的不能直接用等号，值引用的可以
 * <p>
 * intent的拷贝（new了一个）就是原型模式
 * pms详细了解
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        WordDocument wordDocument = new WordDocument();
        wordDocument.addImg("1111");


        WordDocument wordDocumentClone = wordDocument.clone();
        wordDocumentClone.addImg("22222");

        System.out.println(wordDocument.toString());

        System.out.println(wordDocumentClone.toString());


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.clone();

        Intent intent = new Intent();
        intent.clone();
    }
}
