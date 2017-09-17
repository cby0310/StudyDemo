package com.cyb.test.mytest.view.review;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Scroller;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.view.ViewPrint;


/**
 * Created by pc on 2017/5/15.
 */

public class SmoothScrollView extends android.support.v7.widget.AppCompatButton {
    public SmoothScrollView(Context context) {
        super(context);
    }

    public SmoothScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(getContext());
    }

    public SmoothScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Scroller scroller;

public void startScroll(int destX, int destY) {
    int delta = destX - getScrollX();
    scroller.startScroll(getScrollX(), getScrollY(), delta, 0, 2000);
    invalidate();
}

@Override
public void computeScroll() {
    if (scroller.computeScrollOffset()) {
        scrollTo(scroller.getCurrX(), scroller.getCurrY());
        postInvalidate();
    } else {
        MyLog.e("hou");
        ViewPrint.print(this);
    }


}
}
