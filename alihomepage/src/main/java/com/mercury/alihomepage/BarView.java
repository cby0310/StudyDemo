package com.mercury.alihomepage;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

import java.lang.ref.WeakReference;

/**
 * Created by mercury on 2017/12/03.
 */

public class BarView extends FrameLayout {

    private View mView1;
    private View mView2;

    private HeaderView.OnOffsetChangeListener mOnOffsetChangeListener;

    private ViewOffsetHelper mOffsetHelper;

    public BarView(@NonNull Context context) {
        super(context);
    }

    public BarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BarView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mView1 = getChildAt(0);
        mView2 = getChildAt(1);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mOffsetHelper != null) {
            mOffsetHelper.onViewLayout();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mOffsetHelper == null) {
            mOffsetHelper = new ViewOffsetHelper(this);
        }
        ViewParent parent = getParent();
        if (parent != null && parent instanceof HeaderView) {
            HeaderView header = (HeaderView) parent;
            if (mOnOffsetChangeListener == null) {
                mOnOffsetChangeListener = new OffsetChangeListener(this);
            }
            header.addOnOffsetChangeListener(mOnOffsetChangeListener);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewParent parent = getParent();
        if (parent != null && parent instanceof HeaderView) {
            HeaderView header = (HeaderView) parent;
            if (mOnOffsetChangeListener != null) {
                header.removeOnOffsetChangeListener(mOnOffsetChangeListener);
            }
        }
    }

    void offset(int offset) {
        mOffsetHelper.setTopAndBottomOffset(-offset);

        float ratio = 1 - Math.abs(offset) * 1.f / (getResources().getDisplayMetrics().density * 104);
        ratio = MathUtils.constrain(ratio, 0, 1);

        float alpha1 = 1 - Math.min(1, ratio / 0.5f);
        float alpha2 = Math.max((ratio - 0.5f) / 0.5f, 0);

        mView1.setAlpha(alpha1);
        mView2.setAlpha(alpha2);
    }

    private static class OffsetChangeListener implements HeaderView.OnOffsetChangeListener {

        private WeakReference<BarView> mBarViewRef;

        public OffsetChangeListener(BarView barView) {
            mBarViewRef = new WeakReference<>(barView);
        }

        @Override
        public void onOffsetChanged(HeaderView header, int currOffset) {
            BarView barView = mBarViewRef.get();
            if (barView != null) {
                barView.offset(currOffset);
            }
        }
    }
}
