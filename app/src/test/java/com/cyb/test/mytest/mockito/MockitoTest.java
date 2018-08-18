package com.cyb.test.mytest.mockito;

import android.text.TextUtils;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by chaoyongbing on 2017/10/31 18:07.
 */

public class MockitoTest {

    @Test
    public void test1() {
        IMathUtils mathUtils = mock(IMathUtils.class); // 生成mock对象

        when(mathUtils.abs(-1)).thenReturn(1); // 当调用abs(-1)时，返回1

        int abs = mathUtils.abs(-1); // 输出结果 1
        abs = mathUtils.abs(-1);

        verify(mathUtils, atLeast(1)).abs(-1);
        verify(mathUtils, times(2)).abs(-1);

        assertEquals(abs, 1);// 测试通过
    }

    @Test
    public void test2() {
        Calculater calculater = new Calculater(new IMathUtilsTest());
        double a = calculater.divide(10, 5);
        assertEquals(a, 2, 0);
    }

    @Test
    public void test3() {
        IMathUtils mathUtils = mock(IMathUtils.class);

        when(mathUtils.checkZero(0)).thenReturn(true);
        when(mathUtils.checkZero(1)).thenReturn(false);

        Calculater calculater = new Calculater(mathUtils);
        assertEquals(calculater.divide(6, 3), 2, 0);

        assertEquals(calculater.divide(6, 0), 2, 0);

    }


    @Test
    public void test4() {
        assertEquals(TextUtils.isEmpty(""), true);
    }


    @Test
    public void test5() {
        List list = new ArrayList();
        //监控一个真实的对象
        List spy = Mockito.spy(list);

//        when(spy.size()).thenReturn(100);
        //因为当调用spy.get(0)时会调用真实对象的get(0)函数，此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
//        when(spy.get(0)).thenReturn("foo");

        doReturn("foo").when(spy).get(0);

        System.out.println(spy.get(0));

        //通过spy对象调用真实对象的函数
        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(1));
        System.out.println(spy.size());

        //交互验证
        verify(spy).add("one");
        verify(spy).add("two");


        //在某些场景中，不光要对方法的返回值和调用进行验证，同时需要验证一系列交互后所传入方法的参数。那么我们可以用参数捕获器来捕获传入方法的参数进行验证，看它是否符合我们的要求。
//        list.add("Haha");
//        ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);
//        verify(list).add(argument.capture());
//        assertEquals("Haha", argument.getValue());

    }
}
