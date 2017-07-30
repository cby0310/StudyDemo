package com.cyb.test.mytest.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class ThreadTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
//        test1();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 12;
            }
        }) {

            @Override
            protected void done() {
                try {
                    Integer a = get();
                    MyLog.e("返回值：" + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                super.done();
            }
        };

        new Thread(futureTask).start();
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
                publishProgress(33);
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
