package com.cyb.test.mytest.mvp;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by pc on 2017/10/24.
 * P基类
 * V:view
 */

public abstract class BasePresenter<V> {
    protected Reference<V> mViewRef;//view接口的弱引用


    ReferenceQueue<V> referenceQueue = new ReferenceQueue();

    protected V getView() {
        return mViewRef.get();
    }

    /**
     * V 和 P 建立关联
     *
     * @param view
     */
    protected void attachView(V view) {
        mViewRef = new WeakReference<V>(view,referenceQueue);
    }

    protected boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    protected void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
