package com.cyb.test.mytest.reactivex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cyb.test.mytest.R;

import io.reactivex.Flowable;

public class RxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

    }


    private void test1() {
//        Flowable.just("Hello world").subscribe(System.out::println);
    }

}
