package com.cyb.test.mytest.dagger2;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/8.
 */
@Component(modules = StudentModule.class)
public interface StudentComponent {
    //    void inject(Dagger2Activity dagger2Activity);
    Student student1();
}
