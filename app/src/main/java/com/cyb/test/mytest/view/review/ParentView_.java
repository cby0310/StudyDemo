package com.cyb.test.mytest.view.review;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.cyb.test.mytest.MyLog;


/**
 * Created by pc on 2017/5/16.
 */

public class ParentView_ extends LinearLayout {
    public ParentView_(Context context) {
        super(context);
    }

    public ParentView_(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentView_(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int mLastX;
    int mLastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastY;
                int deltaY = y - mLastY;
                if (/*父控件需要处理*/true) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }

    int mLastXIntercept;
    int mLastYIntercept;

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            return false;
        } else {
            return true;
        }
    }

    public boolean onInterceptTouchEvent1(MotionEvent ev) {
        boolean intercepted = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercepted = false;//一定要不拦截，否则事件到不了子控件了
                break;
            case MotionEvent.ACTION_MOVE:
                if (true/*父控件需要拦截此事件*/) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                intercepted = false;
                break;
        }
        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MyLog.e("onTouchEvent   parent事件:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                MyLog.e("onTouchEvent   parent事件:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                MyLog.e("onTouchEvent   parent事件:ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                MyLog.e("onTouchEvent   parent事件:ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                MyLog.e("onTouchEvent   parent事件:ACTION_HOVER_ENTER");
                break;
        }
        boolean result = super.onTouchEvent(event);
        MyLog.e("onTouchEvent   parent事件:" + result);
        return result;
    }
}
