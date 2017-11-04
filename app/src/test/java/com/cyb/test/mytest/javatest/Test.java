package com.cyb.test.mytest.javatest;

/**
 * Created by chaoyongbing on 2017/11/3 11:20.
 */

public class Test {

    public int age;

    private void testMethod(Callback callback) {
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerClass2 innerClass2 = innerClass.new InnerClass2();
    }

    interface Callback {
        void call(int a);
    }

    public class InnerClass {
        public String name;
        public int age;

        public void method1() {
            testMethod(new Callback() {
                @Override
                public void call(int a) {

                }
            });

            Test.this.age = 2;
            age = 1;

            class MethodInnerClass {
                private int age;
            }

            MethodInnerClass methodInnerClass = new MethodInnerClass();
            methodInnerClass.age = 0;
        }

        public class InnerClass2 {

            public void method2() {
                Test.this.age = 2;
                age = 1;
            }

            public class InnerClass3 {

            }
        }
    }

}
