package com.mercury.alihomepage;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by mercury on 2017/12/15.
 * 现在不是AppBarLayout了，而是我们的HeaderView,因此需要重新定义Behavior,
 * 其实和{@link android.support.design.widget.AppBarLayout.ScrollingViewBehavior} 差不多
 */

public class ScrollingViewBehavior extends HeaderScrollingViewBehavior {

    ViewOffsetHelper mOffsetHelper;

    public ScrollingViewBehavior() {
    }

    public ScrollingViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected HeaderView findFirstDependency(List<View> views) {
        for (int i = 0, z = views.size(); i < z; i++) {
            View view = views.get(i);
            if (view instanceof HeaderView) {
                return (HeaderView) view;
            }
        }
        return null;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof HeaderView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final View child, View dependency) {
        HeaderView header = findFirstDependency(parent.getDependencies(child));
        if (header != null) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) header.getLayoutParams();
            CoordinatorLayout.Behavior behavior = lp.getBehavior();
            if (behavior instanceof HeaderView.Behavior) {
                ViewCompat.offsetTopAndBottom(child, (dependency.getBottom() - child.getTop()));
            }
        }
        return false;
    }

    @Override
    protected int getScrollRange(View v) {
        if (v instanceof HeaderView) {
            return ((HeaderView) v).getScrollRange();
        }
        return super.getScrollRange(v);
    }

    @Override
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View child, Rect rectangle, boolean immediate) {
        final HeaderView header = findFirstDependency(coordinatorLayout.getDependencies(child));
        if (header != null) {
            // Offset the rect by the child's left/top
            rectangle.offset(child.getLeft(), child.getTop());

            final Rect parentRect = mTempRect1;
            parentRect.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());

            if (!parentRect.contains(rectangle)) {
                // If the rectangle can not be fully seen the visible bounds, collapse
                // the AppBarLayout
                header.setExpanded(false);
                return true;
            }
        }
        return false;
    }
}
