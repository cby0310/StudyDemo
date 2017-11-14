package com.cyb.test.mytest.aop;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.cyb.test.mytest.MainActivity;
import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.aop.annotation.NetCheck;

public class AopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);


//        getWindow().addFlags();
//        getWindow().setFlags();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        gotoDown();

        startActivity(new Intent(this, MainActivity.class));

        MyLog.e("弹框  前");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyLog.e("弹框");

        Dialog dialog = new ProgressDialog(this);
//        dialog.show();


    }


    @NetCheck
    public void gotoDown() {
        MyLog.e("gotoDown  网络检查通过");
    }
}
