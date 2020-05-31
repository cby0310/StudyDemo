package com.cyb.test.mytest.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chaoyongbing on 2017/11/20 11:48.
 */

public class OkHttpActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        okHttpTest();

    }

    class Interceptor1 implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            System.err.println("Interceptor1  proceed before1");

            Response response = chain.proceed(request);

            System.err.println("Interceptor1  proceed after1");
            return response;
        }
    }

    class Interceptor2 implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            System.err.println("Interceptor2  proceed before2");

            Response response = chain.proceed(request);

            System.err.println("Interceptor2  proceed after2");
            return response;
        }
    }

    public void okHttpTest() {


        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("").openConnection();
            httpURLConnection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Executors.newFixedThreadPool()

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor1());
        builder.addInterceptor(new Interceptor2());
        builder.connectTimeout(10, TimeUnit.SECONDS);

        File httpCacheDirectory = new File(getCacheDir(), "cache");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        builder.cache(cache);

        OkHttpClient client = builder.build();

        Request request = new Request.Builder()
//                .method(null,null)
                .url("https://www.baidu.com/")
                .get()
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            String result = response.body().string();
            System.err.println(result);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.err.println("44444444:" + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.err.println("44444444:" + response.body().string());
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
