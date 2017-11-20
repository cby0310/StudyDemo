package com.cyb.test.mytest.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoyongbing on 2017/11/3 11:20.
 */

public class OutClass {
    public int age;

    private void testMethod(Callback callback) {
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerClass2 innerClass2 = innerClass.new InnerClass2();
    }

    interface Callback {
        void call(int a);
    }

    public static class staticClass {
        public int sAge;
        public String sName;
    }

    public class InnerClass {
        public String name;
        public int age;

        public void method1(final int age) {
            testMethod(new Callback() {
                @Override
                public void call(int a) {
                    int aa = age;
                }
            });

            OutClass.this.age = 2;

            class MethodInnerClass {
//                private int age;
            }

            MethodInnerClass methodInnerClass = new MethodInnerClass();
//            methodInnerClass.age = 0;
        }

        public class InnerClass2 {

            public void method2() {
                OutClass.this.age = 2;
                age = 1;
            }

            public class InnerClass3 {

            }
        }
    }

}
