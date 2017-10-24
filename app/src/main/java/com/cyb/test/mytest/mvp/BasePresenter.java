package com.cyb.test.mytest.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by pc on 2017/10/24.
 * P 基类
 */

public abstract class BasePresenter<T> {
    protected Reference<T> mViewRef;//view接口的弱引用

    protected T getView() {
        return mViewRef.get();
    }

    /**
     * V 和 P 建立关联
     *
     * @param view
     */
    protected void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
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
