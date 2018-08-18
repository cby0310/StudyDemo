package com.cyb.test.mytest.shujujiegousuanfa;

import java.util.Stack;

/**
 * Created by pc on 2017/12/10.
 */

public class SwapValue {

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }


    /**
     * 有可能溢出  经度丢失
     */
    public static void method1() {
        int a = 9;
        int b = 3;
        a = a + b;
        b = a - b;
        a = a - b;
        System.err.println(a + " " + b);
    }

    /**
     * 异或实现
     */
    public static void method2() {
        int a = 9;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.err.println(a + " " + b);
    }

    /**
     * 栈实现，先push 再pop
     */
    public static void method3() {
        Integer a = 9;
        Integer b = 3;
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        stack.push(b);

        a = stack.pop();
        b = stack.pop();
        System.err.println(a + " " + b);
    }

}
