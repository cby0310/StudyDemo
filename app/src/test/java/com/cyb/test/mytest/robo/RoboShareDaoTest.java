package com.cyb.test.mytest.robo;

import android.content.Context;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

public class RoboShareDaoTest extends BaseRoboTest {

    ShareDao mShareDao;

    @Before
    public void setUp() {//执行初始化的操作
        String name = "test.pref";
        mShareDao = new ShareDao(getContext().getSharedPreferences(name, Context.MODE_PRIVATE));
    }

    @Test
    public void testPutAndGet() { //执行各种测试逻辑判断
        mShareDao.put("key", "sssss");
        String key = mShareDao.get("key");
        Assert.assertEquals(key, "sssss");
    }
}
