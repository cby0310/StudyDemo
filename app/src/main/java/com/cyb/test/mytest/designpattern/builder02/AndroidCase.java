package com.cyb.test.mytest.designpattern.builder02;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.cyb.test.mytest.MyApp;
import com.cyb.test.mytest.R;

/**
 * Created by pc on 2017/10/25.
 * 这是一个注释   测试书输入法的注释  草泥马
 */

public class AndroidCase extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_battery_view);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        Toast.makeText(this, "aaa", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {

//        ((ViewGroup)this.findViewById(android.R.id.content)).addView();
        super.onResume();
        case1();
//        Toast.makeText(this, "aaaa", Toast.LENGTH_LONG).show();
//        SharedPreferences sharedPreferences = getSharedPreferences("cyb", Context.MODE_PRIVATE);
//        sharedPreferences.edit().putString("i", "love you").commit();
//
//        Toast.makeText(this, sharedPreferences.getString("i", "1111"), Toast.LENGTH_LONG).show();
    }

    private void case1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true).setTitle("title").setMessage("111111111").setNegativeButton("cancel", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
            }
        });
        alertDialog.show();


    }
}
