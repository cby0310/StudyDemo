package com.cyb.test.mytest.anim;

import android.view.View;

/**
 * Created by Administrator on 2017/2/25.
 */

public class ViewWrapper {
    private View view;

    public ViewWrapper(View view) {
        this.view = view;
    }


    public int getWidth() {
        return view.getLayoutParams().width;
    }


    public void setWidth(int width) {
        view.getLayoutParams().width = width;
        view.requestLayout();
    }

}
