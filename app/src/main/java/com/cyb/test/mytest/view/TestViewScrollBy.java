package com.cyb.test.mytest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.nineoldandroids.view.ViewHelper;


/**
 * Created by pc on 2017/3/5.
 */

public class TestViewScrollBy extends View {

    private int color = Color.RED;

    private Paint paint;

    private VelocityTracker velocityTracker;

    private Scroller scroller;

    public TestViewScrollBy(Context context) {
        super(context);
        init();
    }

    public TestViewScrollBy(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public TestViewScrollBy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestViewScrollBy);
        color = typedArray.getColor(R.styleable.TestViewScrollBy_bg_color, Color.RED);
        typedArray.recycle();

        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        velocityTracker = VelocityTracker.obtain();
        scroller = new Scroller(getContext());
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MyLog.e("onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MyLog.e("onDetachedFromWindow");
        velocityTracker.recycle();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
//        MyLog.e("onVisibilityChanged:" + changedView.toString() + "  " + visibility);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);


        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int radius = Math.min(width, height);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(radius, radius);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(radius, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, radius);
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();


        int width = getMeasuredWidth() - paddingLeft - paddingRight;
        int height = getMeasuredHeight() - paddingBottom - paddingTop;

        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, paint);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);

        MyLog.e("layout  getLeft() = " + getLeft());
        MyLog.e("layout  getTranslationX() = " + getTranslationX());
        MyLog.e("layout  getX() = " + getX());

    }

    private int mLastX;
    private int mLastY;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        velocityTracker.addMovement(event);

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                int deltaX = x - mLastX;
                int deltaY = y - mLastY;

                scrollBy(-deltaX, -deltaY);

                break;
            case MotionEvent.ACTION_UP:
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                int yVelocity = (int) velocityTracker.getYVelocity();

                MyLog.e("1 xVelocity = " + xVelocity);
                MyLog.e("1 yVelocity = " + yVelocity);

                velocityTracker.computeCurrentVelocity(1);
                xVelocity = (int) velocityTracker.getXVelocity();
                yVelocity = (int) velocityTracker.getYVelocity();

                MyLog.e("2 xVelocity = " + xVelocity);
                MyLog.e("2 yVelocity = " + yVelocity);


                velocityTracker.clear();


                ViewHelper.getTranslationX(this);


                MyLog.e(" getLeft() = " + getLeft());
                MyLog.e(" getTranslationX() = " + getTranslationX());
                MyLog.e(" getX() = " + getX());

                MyLog.e(" getScrollX = " + getScrollX() + "    getScrollY = " + getScrollY());


                break;
        }


        mLastX = x;
        mLastY = y;
        return true;
    }
}
