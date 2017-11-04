package com.cyb.test.mytest;

/**
 * Created by chaoyongbing on 2017/11/1 10:19.
 */

public class MyList {
    transient Student[] elementData = new Student[]{new Student("111xiaoming", 1124), new Student("xiaoming1", 11241)};

    public Student get(int index) {
        return elementData[index];
    }
}
