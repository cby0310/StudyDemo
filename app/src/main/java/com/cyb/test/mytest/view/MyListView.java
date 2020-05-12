package com.cyb.test.mytest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.cyb.test.mytest.MyLog;

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        MyLog.e("MyListView onLayout");
    }
}
