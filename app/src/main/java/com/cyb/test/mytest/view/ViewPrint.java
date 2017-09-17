package com.cyb.test.mytest.view;

import android.view.View;

import com.cyb.test.mytest.MyLog;


/**
 * Created by pc on 2017/5/15.
 */

public class ViewPrint {
    public static void print(View view) {
        MyLog.e("left:" + view.getLeft());
        MyLog.e("top:" + view.getTop());
        MyLog.e("right:" + view.getRight());
        MyLog.e("bottom:" + view.getBottom());

        MyLog.e("x:" + view.getX());
        MyLog.e("translationX:" + view.getTranslationX());
        MyLog.e("y:" + view.getY());
        MyLog.e("translationY:" + view.getTranslationY());
    }
}
