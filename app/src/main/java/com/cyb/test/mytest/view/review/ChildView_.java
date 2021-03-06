package com.cyb.test.mytest.view.review;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.cyb.test.mytest.MyLog;


/**
 * Created by pc on 2017/5/16.
 */

public class ChildView_ extends android.support.v7.widget.AppCompatTextView {
    public ChildView_(Context context) {
        super(context);
    }

    public ChildView_(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildView_(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(true);
                MyLog.e("阻止拦截-----------");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        getParent().requestDisallowInterceptTouchEvent(true);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MyLog.e("onTouchEvent  child事件:ACTION_DOWN");
//                if (true) {
//                    return true;
//                }
                break;
            case MotionEvent.ACTION_MOVE:
                MyLog.e("onTouchEvent  child事件:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                MyLog.e("onTouchEvent  child事件:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                MyLog.e("onTouchEvent  child事件:ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                MyLog.e("onTouchEvent  child事件:ACTION_HOVER_ENTER");
                break;
        }
        boolean result = super.onTouchEvent(event);
        MyLog.e("onTouchEvent  child事件:" + result);
        return result;
    }
}
