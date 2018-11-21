package com.cyb.test.mytest.designpattern.interpreter11;

/**
 * 解释器模式，一个典型的场景是对算数表达式的解释，如表达式"m + n + p",mnp就可以看成终结符，+号是非终结符
 * 将复杂的问题简单化，模块化，分离实现，解释执行
 * 安卓中对解释器思想运用的地方是PackageParser，一个方法对应一个AndroidManifest.xml中的一个标签（activity，service，intent-filter等）
 * ，解释执行
 */
public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("1 + 2 + 9 + 100 - 10");
        System.out.println(calculator.calculate());
    }
}
