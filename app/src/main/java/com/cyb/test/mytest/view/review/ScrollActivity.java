package com.cyb.test.mytest.view.review;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.anim.SimpleActivity;
import com.cyb.test.mytest.view.ViewPrint;


public class ScrollActivity extends AppCompatActivity {
    SmoothScrollView button6;

    Handler mHandler = new Handler(Looper.getMainLooper());

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


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ScrollActivity.this, "5000", Toast.LENGTH_SHORT).show();
            }
        }, 5000);

        startActivity(new Intent(this, SimpleActivity.class));
    }
}
