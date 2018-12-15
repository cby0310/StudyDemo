package com.mercury.alihomepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

import java.lang.ref.WeakReference;

/**
 * Created by mercury on 2017/12/03.
 */

public class SnapView extends FrameLayout {

    private HeaderView.OnOffsetChangeListener mOnOffsetChangeListener;

    private View             mContent;
    private ViewOffsetHelper mOffsetHelper;

    public SnapView(Context context) {
        super(context);
    }

    public SnapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SnapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mContent = getChildAt(0);
        mOffsetHelper = new ViewOffsetHelper(mContent);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
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
        final float ratio = 0.5f;
        float alpha = 1 - Math.abs(offset) * 1.f / (0.8f * getHeight());
        alpha = MathUtils.constrain(alpha, 0, 1);
        if (offset < -getHeight()) {
            offset = -getHeight();
        } else if (offset > 0) {
            offset = 0;
        }
        int value = (int) (-offset * ratio);
        mOffsetHelper.setTopAndBottomOffset(value);
        getChildAt(0).setAlpha(alpha);
    }

    private static class OffsetChangeListener implements HeaderView.OnOffsetChangeListener {

        private WeakReference<SnapView> mSnapViewRef;

        public OffsetChangeListener(SnapView snapView) {
            mSnapViewRef = new WeakReference<>(snapView);
        }

        @Override
        public void onOffsetChanged(HeaderView header, int currOffset) {
            SnapView snapView = mSnapViewRef.get();
            if (snapView != null) {
                snapView.offset(currOffset);
            }
        }
    }
}
