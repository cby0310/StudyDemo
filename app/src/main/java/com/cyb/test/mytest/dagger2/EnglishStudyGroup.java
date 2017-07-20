package com.cyb.test.mytest.dagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

public class EnglishStudyGroup {
    public List<Student> students;


    public EnglishStudyGroup() {
        this.students = new ArrayList<>();
        this.students.add(new Student("english1"));
    }
}
