package com.cyb.test.mytest;

import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.util.Log;

import com.cyb.test.mytest.retrofit.ApiManager;
import com.nostra13.universalimageloader.utils.L;

/**
 * Created by pc on 2017/9/17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        L.e("MyApp -> onCreate()");
//        ApiManager apiManager = new ApiManager();
//        apiManager.test();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
