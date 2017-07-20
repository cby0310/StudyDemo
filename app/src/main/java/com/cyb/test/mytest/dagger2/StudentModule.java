package com.cyb.test.mytest.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/6/8.
 * <p>
 * 负责student类对象的创建
 */
@Module
public class StudentModule {

    @Provides
    Student provideStudent() {
        return new Student("nickname");
    }

}
