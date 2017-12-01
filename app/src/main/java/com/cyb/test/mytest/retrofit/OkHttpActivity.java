package com.cyb.test.mytest.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
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
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor1());
        builder.addInterceptor(new Interceptor2());
        builder.connectTimeout(10, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .get()
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            String result = response.body().string();
            System.err.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
