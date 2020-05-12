package com.cyb.test.mytest.jvm.类加载验证;

import com.cyb.test.mytest.jvm.JitTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pc on 2018/7/21.
 */

public class Test {

    Integer a = 1;
    Integer b = 2;
    Integer c = 3;
    Integer d = 3;
    Integer e = 321;
    Integer f = 321;
    Long g = 3L;


    public void forTest() {
        System.err.println(JitTest.NUM);
        Integer[] array = new Integer[]{1, 3, 4, 5};
        for (Integer a : array) {
            array[32] = 1;
            System.err.println(a + 12);
        }
    }

    public static void main(String[] args) {
//        System.err.println(Student.name);
//        System.err.println(Student.age);
//
//        Student student = new Student();
//        student.add(student);
//
//        Student.method(new ArrayList<String>());
//
        new Test().print();
//
//        String str = new String("111");
//        System.err.println(str);
    }

    public void print() {
        System.err.println(c == d); //1
        System.err.println(e == f); //0
        System.err.println(c == (a + b)); //1
        System.err.println(c.equals(a + b)); //1

        System.err.println();
        System.err.println(g == (a + b)); //1
        System.err.println(g.equals(a + b)); //0 ，a+b为integer类型

        System.err.println();
        System.err.println(this.c == this.d); //1
        System.err.println(this.e == this.f); //0

        System.err.println();
        System.err.println(this.c.intValue() == this.a.intValue() + this.b.intValue());//1
        System.err.println(this.c.equals(Integer.valueOf(this.a.intValue() + this.b.intValue())));//1

        System.err.println();
        System.err.println(this.g.longValue() == (long) (this.a.intValue() + this.b.intValue()));//1
        System.err.println(this.g.equals(Integer.valueOf(this.a.intValue() + this.b.intValue())));//0
        System.err.println(Color.valueOf("RED"));
        System.err.println(Color.values()[0]);
//        System.err.println(Color.valueOf(Color.class, "BLUe"));
//        System.err.println(Color.valueOf("RED1"));

        if (false) {
            System.err.println("true");
        } else {
            System.err.println("false");
        }
        String s = "";
        switch (s) {
            case "1":
                System.err.println("1");
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                System.err.println("12");
                break;
        }
        assert s.equals("111");
//        FileReader fileReader = null;
//        try {
//            File file = new File("");
//            fileReader = new FileReader(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }

    }

    enum Color {
        RED, BLUE
    }

}
