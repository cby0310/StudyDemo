package com.cyb.test.mytest.view.review;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;


public class TouchEventActivity extends AppCompatActivity {
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MyLog.e("onTouchEvent   Activity");
        return super.onTouchEvent(event);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
    }

    public void click(View view) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }
}
