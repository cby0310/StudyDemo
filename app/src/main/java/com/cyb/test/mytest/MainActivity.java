package com.cyb.test.mytest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.Toast;

import com.cyb.test.mytest.aop.AopActivity;
import com.cyb.test.mytest.db.DbTestActivity;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Handler handler2 = new Handler();

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.e("Terry", "Handler.Callback handleMessage");
            return true;
        }
    }) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("Terry", "handleMessage");
        }
    };


    private MyThread myThread;

    private ImageView image;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LruCache lruCache = new LruCache<String, Bitmap>(120) {
//            @Override
//            protected int sizeOf(String key, Bitmap value) {
//                return super.sizeOf(key, value);
//            }
//        };
//        lruCache.put("", null);
//        lruCache.get("");
//
//        Map<String, String> map = new HashMap<>();
//        map.keySet();
//        map.entrySet().iterator().hasNext();
//        map.entrySet();
//        map.values();
//
//
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        image = (ImageView) findViewById(R.id.image);
//
//        Glide.with(this).load("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3794371817,2637991827&fm=58").asGif()
//                .placeholder(R.mipmap.ic_launcher).into(image);
//
//        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                looper.quitSafely();
//            }
//        });
//
//        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myThread = new MyThread();
//                myThread.start();
//            }
//        });
//
//
//        float widthPixels = getResources().getDisplayMetrics().widthPixels;
//        float heightPixels = getResources().getDisplayMetrics().heightPixels;
//
//        float desity = getResources().getDisplayMetrics().density;
//        int densityDpi = getResources().getDisplayMetrics().densityDpi;
//        float scaledDensity = getResources().getDisplayMetrics().scaledDensity;
//
//        Log.e("Terry", desity + "  " + densityDpi + "  " + scaledDensity);
//        Log.e("Terry", widthPixels + "  " + heightPixels);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file://aa.txt"))) {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }


        startActivity(new Intent(this, DbTestActivity.class));

    }

    private Looper looper;

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            handler.sendEmptyMessage(4);


//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.e("Terry", "handler.post");
//                    }
//                });
            Log.e("Terry", "。。。。。。");

            Looper.prepare();
            Toast.makeText(MainActivity.this, "ss", Toast.LENGTH_LONG).show();
            looper = Looper.myLooper();
            Log.e("Terry", "阻塞了，这一句下面的不会执行。");
            Looper.loop();
            Log.e("Terry", "解除阻塞。。。");
            Toast.makeText(MainActivity.this, "aaaaa", Toast.LENGTH_LONG).show();
            Log.e("Terry", "这一次不会阻塞。。。toast也不会出来");
            Looper.loop();
        }
    }

}
