package com.mercury.alihomepage;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by mercury on 2017/12/15.
 * design包下拷贝过来的，做了修改
 * {@link android.support.design.widget.HeaderBehavior}
 */

public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    private static final int INVALID_POINTER = -1;

    private Runnable mFlingRunnable;
    protected ScrollerCompat mScroller;

    private boolean mIsBeingDragged;
    private int mActivePointerId = INVALID_POINTER;
    private int mLastMotionY;
    private int mTouchSlop = -1;
    private VelocityTracker mVelocityTracker;
    private int mOverScrollDelta;

    public static final String TAG = "HeaderBehavior";

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent ev) {
        if (mTouchSlop < 0) {
            mTouchSlop = ViewConfiguration.get(parent.getContext()).getScaledTouchSlop();
        }

        switch (MotionEventCompat.getActionMasked(ev)) {
            case MotionEvent.ACTION_DOWN: {
                final int x = (int) ev.getX();
                final int y = (int) ev.getY();

                if (parent.isPointInChildBounds(child, x, y) && canDragView(child)) {
                    mOverScrollDelta = 0;
                    mLastMotionY = y;
                    mActivePointerId = ev.getPointerId(0);
                    ensureVelocityTracker();
                } else {
                    return false;
                }
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final int activePointerIndex = ev.findPointerIndex(mActivePointerId);
                if (activePointerIndex == -1) {
                    return false;
                }

                final int y = (int) ev.getY(activePointerIndex);
                int dy = mLastMotionY - y;

                if (!mIsBeingDragged && Math.abs(dy) > mTouchSlop) {
                    startDragging();
                    if (dy > 0) {
                        dy -= mTouchSlop;
                    } else {
                        dy += mTouchSlop;
                    }
                }

                if (mIsBeingDragged) {
                    mLastMotionY = y;

                    // 处理OverScroll，超出可滚动范围时缓存超出部分，反向滑动时先消费缓存的部分。
                    if (mOverScrollDelta != 0) {
                        if (dy > 0 && mOverScrollDelta > 0) {
                            mOverScrollDelta += dy;
                            break;
                        } else if (dy < 0 && mOverScrollDelta < 0) {
                            mOverScrollDelta += dy;
                            break;
                        } else {
                            if (Math.abs(mOverScrollDelta) >= Math.abs(dy)) {
                                // 不能完全消费
                                mOverScrollDelta += dy;
                                break;
                            } else {
                                // 有多余dy
                                dy += mOverScrollDelta;
                                mOverScrollDelta = 0;
                            }
                        }
                    }

                    // We're being dragged so scroll the ABL
                    int scrolled = scroll(parent, child, dy, getMaxDragOffset(child), 0);
                    if (scrolled != dy) {
                        mOverScrollDelta += dy - scrolled;
                    }
                }
                break;
            }

            case MotionEvent.ACTION_UP:
                if (mVelocityTracker != null) {
                    mVelocityTracker.addMovement(ev);
                    mVelocityTracker.computeCurrentVelocity(1000);
                    float yvel = VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                            mActivePointerId);
                    fling(parent, child, -getScrollRangeForDragFling(child), 0, yvel);
                }
                // $FALLTHROUGH
            case MotionEvent.ACTION_CANCEL: {
                stopDragging();
                mActivePointerId = INVALID_POINTER;
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }
                break;
            }
        }

        if (mVelocityTracker != null) {
            mVelocityTracker.addMovement(ev);
        }

        return true;
    }

    private void startDragging() {
        mIsBeingDragged = true;
        onStartDragging();
    }

    private void stopDragging() {
        mIsBeingDragged = false;
        onStopDragging();
    }

    protected void onStartDragging() {

    }

    protected void onStopDragging() {

    }

    public int setHeaderTopBottomOffset(CoordinatorLayout parent, V header, int newOffset) {
        return setHeaderTopBottomOffset(parent, header, newOffset,
                Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout parent, V header, int newOffset,
                                        int minOffset, int maxOffset) {
        final int curOffset = getTopAndBottomOffset();
        int consumed = 0;

        if (minOffset != 0 && curOffset >= minOffset && curOffset <= maxOffset) {
            // If we have some scrolling range, and we're currently within the min and max
            // offsets, calculate a new offset
            newOffset = MathUtils.constrain(newOffset, minOffset, maxOffset);

            if (curOffset != newOffset) {
                setTopAndBottomOffset(newOffset);
                // Update how much dy we have consumed
                consumed = curOffset - newOffset;
            }
        }

        return consumed;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, V header,
                            int dy, int minOffset, int maxOffset) {
        return setHeaderTopBottomOffset(coordinatorLayout, header,
                getTopBottomOffsetForScrollingSibling() - dy, minOffset, maxOffset);
    }

    protected boolean fling(CoordinatorLayout coordinatorLayout, V layout, int minOffset,
                            int maxOffset, float velocityY) {
        if (mFlingRunnable != null) {
            layout.removeCallbacks(mFlingRunnable);
            mFlingRunnable = null;
        }

        if (mScroller == null) {
            mScroller = ScrollerCompat.create(layout.getContext());
        }

        mScroller.fling(
                0, getTopAndBottomOffset(), // curr
                0, Math.round(velocityY), // velocity.
                0, 0, // x
                minOffset, maxOffset); // y

        if (mScroller.computeScrollOffset()) {
            mFlingRunnable = new FlingRunnable(coordinatorLayout, layout);
            ViewCompat.postOnAnimation(layout, mFlingRunnable);
            return true;
        } else {
            onFlingFinished(coordinatorLayout, layout);
            return false;
        }
    }

    protected void stopFling() {
        if (mScroller != null) {
            mScroller.abortAnimation();
        }
    }

    /**
     * Called when a fling has finished, or the fling was initiated but there wasn't enough
     * velocity to start it.
     */
    protected void onFlingFinished(CoordinatorLayout parent, V layout) {
        // no-opa
    }

    /**
     * Return true if the view can be dragged.
     * 这里一直返回false，实际上子类APHeaderView重写了，返回true
     */
    protected boolean canDragView(V view) {
        return false;
    }

    /**
     * Returns the maximum px offset when {@code view} is being dragged.
     */
    protected int getMaxDragOffset(V view) {
        return -view.getHeight();
    }

    protected int getScrollRangeForDragFling(V view) {
        return view.getHeight();
    }

    //初始化VelocityTracker
    private void ensureVelocityTracker() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private class FlingRunnable implements Runnable {
        private final CoordinatorLayout mParent;
        private final V mLayout;

        FlingRunnable(CoordinatorLayout parent, V layout) {
            mParent = parent;
            mLayout = layout;
        }

        @Override
        public void run() {
            if (mLayout != null && mScroller != null) {
                if (mScroller.computeScrollOffset()) {
                    setHeaderTopBottomOffset(mParent, mLayout, mScroller.getCurrY());
                    // Post ourselves so that we run on the next animation
                    ViewCompat.postOnAnimation(mLayout, this);
                } else {
                    onFlingFinished(mParent, mLayout);
                }
            }
        }
    }
}
