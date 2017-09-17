package com.cyb.test.mytest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import android.widget.TextView;


/**
 * Created by pc on 2017/3/5.
 */

public class TestViewSmoothScrollTo extends TextView {

    private Scroller scroller = new Scroller(getContext(), new AccelerateInterpolator());


    public TestViewSmoothScrollTo(Context context) {
        super(context);
    }

    public TestViewSmoothScrollTo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewSmoothScrollTo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;

        int scrollY = getScrollY();
        int deltaY = destY - scrollY;

        scroller.startScroll(scrollX, scrollY, deltaX, deltaY, 5000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();

//            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
//            horizontalScrollView.smoothScrollTo();
        }
    }
}
