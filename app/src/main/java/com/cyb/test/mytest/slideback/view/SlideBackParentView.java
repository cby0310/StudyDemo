package com.cyb.test.mytest.slideback.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;

import com.cyb.test.mytest.MyLog;

/**
 * Created by Administrator on 2017/6/30.
 */

public class SlideBackParentView extends FrameLayout {

    private Scroller scoller;
    private VelocityTracker velocityTracker;
    private SlideCallback slideCallback;

    private View scrollView;

    private int touchSlop;

    private int mLastX;
    private int mLastY;

    public void setSlideCallback(SlideCallback slideCallback) {
        this.slideCallback = slideCallback;
    }

    public void setScrollView(View scrollView) {
        this.scrollView = scrollView;
    }


    public SlideBackParentView(Context context) {
        super(context);
        init();
    }


    public SlideBackParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideBackParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        velocityTracker = VelocityTracker.obtain();
        scoller = new Scroller(getContext());
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        velocityTracker.addMovement(ev);
        MyLog.e("getAction = " + ev.getAction());
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = mLastX - x;
                int deltaY = mLastY - y;
                if (Math.abs(deltaX) > touchSlop && scrollView != null) {
                    scrollView.scrollBy(deltaX, 0);
                }
                break;
            case MotionEvent.ACTION_UP:
                velocityTracker.computeCurrentVelocity(1000);
                float velocityX = velocityTracker.getXVelocity();
                float velocityY = velocityTracker.getYVelocity();
                MyLog.e("velocityX = " + velocityX);
                if (velocityX > 2000 && velocityX > velocityY) {
                    if (slideCallback != null) {
                        slideCallback.onFinish();
                        return true;
                    }
                }
                velocityTracker.clear();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        velocityTracker.recycle();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (true) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    public interface SlideCallback {
        void onFinish();
    }
}
