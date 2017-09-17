package com.cyb.test.mytest.view.review;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.cyb.test.mytest.MyLog;


/**
 * Created by pc on 2017/5/16.
 */

public class ParentView2 extends LinearLayout {
    public ParentView2(Context context) {
        super(context);
    }

    public ParentView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MyLog.e("dispatchTouchEvent   parent2事件:ACTION_DOWN");
                if (true)
                    return true;
                break;
            case MotionEvent.ACTION_MOVE:
                MyLog.e("dispatchTouchEvent   parent2事件:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                MyLog.e("dispatchTouchEvent   parent2事件:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                MyLog.e("dispatchTouchEvent   parent2事件:ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                MyLog.e("dispatchTouchEvent   parent2事件:ACTION_HOVER_ENTER");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MyLog.e("onInterceptTouchEvent   parent2事件:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                MyLog.e("onInterceptTouchEvent   parent2事件:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                MyLog.e("onInterceptTouchEvent   parent2事件:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                MyLog.e("onInterceptTouchEvent   parent2事件:ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                MyLog.e("onInterceptTouchEvent   parent2事件:ACTION_HOVER_ENTER");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MyLog.e("onTouchEvent   parent2事件:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                MyLog.e("onTouchEvent   parent2事件:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                MyLog.e("onTouchEvent   parent2事件:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                MyLog.e("onTouchEvent   parent2事件:ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                MyLog.e("onTouchEvent   parent2事件:ACTION_HOVER_ENTER");
                break;
        }
        return super.onTouchEvent(event);
    }
}
