package com.cyb.test.mytest.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cyb.test.mytest.R;

import javax.inject.Inject;

public class Dagger2Activity extends AppCompatActivity {

    @Inject
    Student student;

    @Inject
    EnglishStudyGroup englishStudyGroup;

    private StudentComponent studentComponent;
    private EnglishStudyGroupComponent englishStudyGroupComponent;

    public void test() {
//        System.err.print(student.name);
        Log.e("Terry", "student.name -->" + student.name);
        Log.e("Terry", "students.students -->" + englishStudyGroup.students);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        studentComponent =
                DaggerStudentComponent
                        .builder()
                        .studentModule(new StudentModule())
                        .build();

        englishStudyGroupComponent =
                DaggerEnglishStudyGroupComponent
                        .builder()
                        .englishStudyGroupModule(new EnglishStudyGroupModule())
                        .studentComponent(studentComponent)
                        .build();

        englishStudyGroupComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        test();
    }
}
