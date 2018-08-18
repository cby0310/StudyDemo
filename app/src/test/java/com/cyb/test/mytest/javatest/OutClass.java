package com.cyb.test.mytest.javatest;

/**
 * Created by chaoyongbing on 2017/11/3 11:20.
 */

public class OutClass {

    public int age;

    private void testMethod(Callback callback) {
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerClass2 innerClass2 = innerClass.new InnerClass2();
    }

    private void cun(final String name1) {
        InnerClass innerClass = new InnerClass() {
            void aa() {
                String a = name1;
            }

        };
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

            OutClass.this.age = 2;
            age = 1;

            class MethodInnerClass {
                private int age;
            }

            MethodInnerClass methodInnerClass = new MethodInnerClass();
            methodInnerClass.age = 0;
        }

        public class InnerClass2 {

            public void method2(int height) {
                OutClass.this.age = 2;
                age = 1;
                age = height;
            }
        }
    }

}
