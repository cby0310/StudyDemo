package com.cyb.test.mytest.aop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.aop.annotation.NetCheck;

public class AopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);
        gotoDown();
    }


    @NetCheck
    public void gotoDown() {
        MyLog.e("gotoDown  网络检查通过");
    }
}
