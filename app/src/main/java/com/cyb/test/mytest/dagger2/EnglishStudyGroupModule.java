package com.cyb.test.mytest.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/6/9.
 */
@Module
public class EnglishStudyGroupModule {

    @Provides
    EnglishStudyGroup provideEnglishStudyGroup() {
        return new EnglishStudyGroup();
    }
}
