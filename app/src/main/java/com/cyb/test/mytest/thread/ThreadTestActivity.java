package com.cyb.test.mytest.thread;

import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cyb.test.mytest.R;

import java.util.List;

public class ThreadTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
        test1();
    }


    private void test1() {


        AsyncTask<Integer, Integer, Float> asyncTaska = new AsyncTask<Integer, Integer, Float>() {
            @Override
            protected Float doInBackground(Integer... params) {
                return null;
            }
        };


        AsyncTask<Integer, Integer, Float> asyncTask = new AsyncTask<Integer, Integer, Float>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);

            }

            @Override
            protected void onCancelled(Float aFloat) {
                super.onCancelled(aFloat);
            }

            @Override
            protected Float doInBackground(Integer... params) {
                return 12f;
            }

            @Override
            protected void onPostExecute(Float aFloat) {
                super.onPostExecute(aFloat);
            }
        };
        asyncTask.execute();
        asyncTask.cancel(false);
    }
}
