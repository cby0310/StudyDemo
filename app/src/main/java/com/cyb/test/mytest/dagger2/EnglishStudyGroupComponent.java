package com.cyb.test.mytest.dagger2;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/9.
 */

@Component(dependencies = StudentComponent.class, modules = EnglishStudyGroupModule.class)
public interface EnglishStudyGroupComponent {
    void inject(Dagger2Activity dagger2Activity);
}
