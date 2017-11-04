package com.cyb.test.mytest.robo;

import android.content.Context;
import android.os.Build;

import com.cyb.test.mytest.BuildConfig;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * Created by chaoyongbing on 2017/11/3 18:41.
 */
@RunWith(MyRoboTestRunner.class)
@Config(constants = BuildConfig.class,
    /*    manifest = Config.NONE,*/
        sdk = Build.VERSION_CODES.JELLY_BEAN,
        application = RoboApp.class)
public class BaseRoboTest {
    protected Context getContext() {
        return RuntimeEnvironment.application;
    }
}
