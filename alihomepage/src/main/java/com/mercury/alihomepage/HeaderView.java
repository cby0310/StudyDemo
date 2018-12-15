package com.mercury.alihomepage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.mercury.material_design.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * container which implements the feature of index-page
 */

@CoordinatorLayout.DefaultBehavior(HeaderView.Behavior.class)
public class HeaderView extends ViewGroup {

    public static final String TAG_A = "APHeaderView";

    private static final int PENDING_ACTION_COLLAPSED = 0x0001;     //折叠
    private static final int PENDING_ACTION_EXPANDED = 0x0010;      //展开

    private View mBar;          //头部子组件
    private View mSnapView;     //内容子组件
    private List<View> mScrollableViews;    //内部其它子组件的集合
    private List<OnOffsetChangeListener> mOnOffsetChangeListeners;
    private OnHeaderFlingUnConsumedListener mOnHeaderFlingUnConsumedListener;

    private int mPendingAction;

    public HeaderView(@NonNull Context context) {
        this(context, null);
    }

    public HeaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View getBar() {
        return mBar;
    }

    public View getSnapView() {
        return mSnapView;
    }

    public List<View> getScrollableViews() {
        return mScrollableViews;
    }

    public int getScrollRange() {
        int range = mSnapView.getMeasuredHeight();
        if (mScrollableViews != null) {
            for (View sv : mScrollableViews) {
                range += sv.getMeasuredHeight();
            }
        }
        return range;
    }

    /**
     *
     * @return  自动收起snapView的offset阈值
     */
    private int getSnapRange() {
        return mSnapView.getHeight();
    }

    /**
     * 该组件应该在CoordinatorLayout中使用
     * @return  该组件默认使用的自定义的 {@link Behavior}
     */
    public Behavior getBehavior() {
        LayoutParams lp = getLayoutParams();
        if (lp != null && lp instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams clp = (CoordinatorLayout.LayoutParams) lp;
            CoordinatorLayout.Behavior b = clp.getBehavior();
            if (b instanceof Behavior) {
                return (Behavior) b;
            }
            return null;
        }
        return null;
    }

    public void setExpanded(boolean expanded) {
        mPendingAction = expanded ? PENDING_ACTION_EXPANDED : PENDING_ACTION_COLLAPSED;
        requestLayout();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final int childCount = getChildCount();
        if (childCount < 2) {
            throw new IllegalStateException("Child count must >= 2");
        }
        mBar = findViewById(R.id.barView);
        mSnapView = findViewById(R.id.snapView);
        mScrollableViews = new ArrayList<>();
        //将内部其它的子组件添加到集合中
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            if (v != mBar && v != mSnapView) {
                mScrollableViews.add(v);
            }
        }
        mBar.bringToFront();    //头部子组件显示在顶层
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightSize == 0) {
            heightSize = Integer.MAX_VALUE;
        }

        int height = 0;

        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChildWithMargins(
                    child,
                    MeasureSpec.makeMeasureSpec(widthSize - getPaddingLeft() - getPaddingRight(), MeasureSpec.EXACTLY),
                    0,
                    MeasureSpec.makeMeasureSpec(heightSize - getPaddingTop() - getPaddingBottom(), MeasureSpec.AT_MOST),
                    height
            );
            height += child.getMeasuredHeight();
        }

        height += getPaddingTop() + getPaddingBottom();
        //根据子组件获取真实的测量高度
        setMeasuredDimension(widthSize, height);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(super.generateDefaultLayoutParams());
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(super.generateLayoutParams(attrs));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childTop = getPaddingTop();
        int childLeft = getPaddingLeft();
        mBar.layout(childLeft, childTop, childLeft + mBar.getMeasuredWidth(), childTop + mBar.getMeasuredHeight());
        childTop += mBar.getMeasuredHeight();

        mSnapView.layout(childLeft, childTop, childLeft + mSnapView.getMeasuredWidth(), childTop + mSnapView.getMeasuredHeight());

        childTop += mSnapView.getMeasuredHeight();

        //摆放内部其它组件的位置
        for (View v : mScrollableViews) {
            v.layout(childLeft, childTop, childLeft + v.getMeasuredWidth(), childTop + v.getMeasuredHeight());
            childTop += v.getMeasuredHeight();
        }
    }

    public void addOnOffsetChangeListener(OnOffsetChangeListener listener) {
        if (mOnOffsetChangeListeners == null) {
            mOnOffsetChangeListeners = new ArrayList<>();
        }
        if (mOnOffsetChangeListeners.contains(listener)) {
            return;
        }
        mOnOffsetChangeListeners.add(listener);
    }

    public void removeOnOffsetChangeListener(OnOffsetChangeListener listener) {
        if (mOnOffsetChangeListeners == null || mOnOffsetChangeListeners.size() == 0) {
            return;
        }
        if (mOnOffsetChangeListeners.contains(listener)) {
            mOnOffsetChangeListeners.remove(listener);
        }
    }

    private void dispatchOffsetChange(int offset) {
        if (mOnOffsetChangeListeners != null) {
            for (OnOffsetChangeListener listener : mOnOffsetChangeListeners) {
                listener.onOffsetChanged(this, offset);
            }
        }
    }

    public void setOnHeaderFlingUnConsumedListener(OnHeaderFlingUnConsumedListener onHeaderFlingUnConsumedListener) {
        mOnHeaderFlingUnConsumedListener = onHeaderFlingUnConsumedListener;
    }

    /**
     * Interface definition for a callback to be invoked when an {@link HeaderView}'s offset changed
     */
    public interface OnOffsetChangeListener {
        void onOffsetChanged(HeaderView header, int currOffset);
    }

    public interface OnHeaderFlingUnConsumedListener {
        int onFlingUnConsumed(HeaderView header, int targetOffset, int unconsumed);
    }

    /**
     * The default {@link Behavior} for {@link HeaderView}.Implements the necessary nested
     * scroll handling with offseting.
     * 真正处理了内部交互的地方，扮演的角色相当于{@link android.support.design.widget.AppBarLayout.Behavior}
     */
    public static class Behavior extends HeaderBehavior<HeaderView> {
        private ValueAnimator mOffsetAnimator;
        private boolean mSkipNestedPreScroll;
        private WeakReference<View> mLastNestedScrollingChildRef;

        private boolean mWasFlung;
        private boolean mShouldDispatchFling;

        private int mTempFlingDispatchConsumed;
        private int mTempFlingMinOffset;
        private int mTempFlingMaxOffset;

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected boolean canDragView(HeaderView view) {
            if (mLastNestedScrollingChildRef != null) {
                //NestedScrollView
                View scrollable = mLastNestedScrollingChildRef.get();
                return scrollable != null
                        && scrollable.isShown()
                        && !scrollable.canScrollVertically(-1)
                        && getTopAndBottomOffset() > -view.getScrollRange();
            }
            return true;
        }

        @Override
        protected int getMaxDragOffset(HeaderView view) {
            return -view.getScrollRange();
        }

        @Override
        protected int getScrollRangeForDragFling(HeaderView view) {
            return view.getScrollRange();
        }

        @Override
        public int setHeaderTopBottomOffset(CoordinatorLayout parent, HeaderView header, int newOffset, int minOffset, int maxOffset) {
            final int curOffset = getTopAndBottomOffset();
            final int min;
            final int max;
            if (mShouldDispatchFling) {
                min = Math.max(mTempFlingMinOffset, minOffset);
                max = Math.min(mTempFlingMaxOffset, maxOffset);
            } else {
                min = minOffset;
                max = maxOffset;
            }

            int consumed = super.setHeaderTopBottomOffset(parent, header, newOffset, min, max);
            // consumed 的符号和 dy 相反

            // 监听到手势的变化
            header.dispatchOffsetChange(getTopAndBottomOffset());

            int delta = 0;

            if (mShouldDispatchFling && header.mOnHeaderFlingUnConsumedListener != null) {
                int unconsumedY = newOffset - curOffset + consumed - mTempFlingDispatchConsumed;
                if (unconsumedY != 0) {
                    delta = header.mOnHeaderFlingUnConsumedListener.onFlingUnConsumed(header, newOffset, unconsumedY);
                }
                mTempFlingDispatchConsumed += -delta;
            }

            return consumed + delta;
        }

        @Override
        protected boolean fling(CoordinatorLayout coordinatorLayout, HeaderView layout, int minOffset, int maxOffset, float velocityY) {
            int min = minOffset;
            int max = maxOffset;
            if (velocityY < 0) {
                // 向上滚动
                mShouldDispatchFling = true;
                mTempFlingDispatchConsumed = 0;
                mTempFlingMinOffset = minOffset;
                mTempFlingMaxOffset = maxOffset;
                min = Integer.MIN_VALUE;
                max = Integer.MAX_VALUE;
            }
            return super.fling(coordinatorLayout, layout, min, max, velocityY);
        }

        //快速滑动(fling)的动作结束，或者已经初始化完毕但是还么有产生足够的速度时回调
        @Override
        protected void onFlingFinished(CoordinatorLayout parent, HeaderView header) {
            mShouldDispatchFling = false;
            checkSnap(parent, header);
            // TODO: 2018/2/10 就是这里没有调用
            Log.i(TAG_A, "onFlingFinished: ");
        }

        private void checkSnap(CoordinatorLayout parent, HeaderView header) {
            // TODO: 2018/1/28 明明松手时却没有调用该方法，从而无法完成平滑移动
            int offset = getTopAndBottomOffset();       //该组件的坐标偏移量
            int snapRange = header.getSnapRange();      //该组件可以滑动的距离=内部snap的高度
            int snapCollapsedOffset = -snapRange;       //完全折叠后的相对坐标
            int snapExpandedOffset = 0;                 //完全展开后的相对坐标
            Log.i(TAG_A, "offset: " + offset + "\tsnapRange:" + snapRange);
            if (offset > snapCollapsedOffset && offset < snapExpandedOffset) {
                int target = offset < (snapCollapsedOffset + snapExpandedOffset) / 2 ?
                        snapCollapsedOffset : snapExpandedOffset;
                //平滑移动到指定位置，这是关键
                animateOffsetTo(parent, header, target, 0);
            }
        }

        @Override
        public boolean onLayoutChild(CoordinatorLayout parent, HeaderView child, int layoutDirection) {
            boolean handled = super.onLayoutChild(parent, child, layoutDirection);

//            if (child.mPendingAction != 0) {
//                if ((child.mPendingAction & PENDING_ACTION_COLLAPSED) != 0) {
//                    setHeaderTopBottomOffset(parent, child, -child.getScrollRange());
//                } else if ((child.mPendingAction & PENDING_ACTION_EXPANDED) != 0) {
//                    setHeaderTopBottomOffset(parent, child, 0);
//                }
//            }

            child.dispatchOffsetChange(getTopAndBottomOffset());
            return handled;
        }


        private void animateOffsetTo(final CoordinatorLayout coordinatorLayout,
                                     final HeaderView child, final int offset, float velocity) {
            final int distance = Math.abs(getTopBottomOffsetForScrollingSibling() - offset);

            int duration;
            velocity = Math.abs(velocity);
            if (velocity > 0) {
                duration = Math.round(1000 * (distance / velocity));
            } else {
                final float distanceRatio = (float) distance / child.getHeight();
                duration = (int) ((distanceRatio + 1) * 150);
            }

            animateToOffset(coordinatorLayout, child, offset, duration);
        }

        private void animateToOffset(final CoordinatorLayout parent, final HeaderView header, final int target, int duration) {
            final int current = getTopAndBottomOffset();
            if (current == target) {
                if (mOffsetAnimator != null) {
                    mOffsetAnimator.cancel();
                }
            }
            if (mOffsetAnimator == null) {
                mOffsetAnimator = new ValueAnimator();
                mOffsetAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        setHeaderTopBottomOffset(parent, header, (Integer) animation.getAnimatedValue());
                    }
                });
            } else {
                mOffsetAnimator.cancel();
            }
            mOffsetAnimator.setDuration(duration);
            mOffsetAnimator.setIntValues(current, target);
            mOffsetAnimator.start();
        }

        @Override
        protected void onStartDragging() {
            super.onStartDragging();
            if (mOffsetAnimator != null) {
                mOffsetAnimator.cancel();
            }
            mShouldDispatchFling = false;
            stopFling();
        }

        @Override
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull
                HeaderView child, View directTargetChild, View target, int nestedScrollAxes) {
            boolean start = (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) > 0
                    && child.getScrollRange() > 0
                    && coordinatorLayout.getHeight() - directTargetChild.getHeight() <= child.getHeight();
            if (start && mOffsetAnimator != null) {
                mOffsetAnimator.cancel();
            }
            mLastNestedScrollingChildRef = null;
            mWasFlung = false;
            mShouldDispatchFling = false;
            stopFling();
            return start;
        }

        @Override
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull HeaderView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed) {
            if (dy > 0 && !mSkipNestedPreScroll) {
                int min, max;
                min = -child.getScrollRange();
                max = 0;
                consumed[1] = scroll(coordinatorLayout, child, dy, min, max);
            }
        }

        @Override
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull HeaderView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
            if (dyUnconsumed < 0) {
                scroll(coordinatorLayout, child, dyUnconsumed, -child.getScrollRange(), 0);
                mSkipNestedPreScroll = true;
            } else {
                mSkipNestedPreScroll = false;
            }
        }

        /**
         * 嵌套滑动结束时调用
         * @param coordinatorLayout
         * @param child
         * @param target CoordinatorLayout中同级的组件,可滑动并且定义了Behavior
         */
        @Override
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull HeaderView child, @NonNull View target) {
            if (!mWasFlung) {

            }
            checkSnap(coordinatorLayout, child);
            Log.i(TAG_A, "onStopNestedScroll: " + mWasFlung);
            mSkipNestedPreScroll = false;
            mLastNestedScrollingChildRef = new WeakReference<>(target);
        }

        @Override
        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull HeaderView child, @NonNull View target, float velocityX, float velocityY) {
            if (velocityY > 0 && getTopAndBottomOffset() > -child.getScrollRange()) {
                fling(coordinatorLayout, child, -child.getScrollRange(), 0, -velocityY);
                mWasFlung = true;
                return true;
            }
            return false;
        }

        @Override
        public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull HeaderView child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
            mWasFlung = true;
            return false;
        }
    }
}


