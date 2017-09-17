package com.cyb.test.mytest.view.review;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.view.ViewPrint;


public class ScrollActivity extends AppCompatActivity {
    SmoothScrollView button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        button6 = (SmoothScrollView) findViewById(R.id.button6);
        MyLog.e("qian");
        ViewPrint.print(button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6.startScroll(200, 0);
            }
        });


    }
}
