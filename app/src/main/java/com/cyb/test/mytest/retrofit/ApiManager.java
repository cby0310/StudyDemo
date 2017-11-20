package com.cyb.test.mytest.retrofit;

import android.database.Cursor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.io.PipedReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ApiManager {


    private static Retrofit create() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(15, TimeUnit.SECONDS);

        if (true) {
            Interceptor myInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(chain.request());
                }
            };

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(
                    new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {

                        }
                    });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder.addInterceptor(myInterceptor);
        }


        return new Retrofit.Builder()
                .baseUrl("")
//                效果等同于client
//                .callFactory(builder.build())
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
//                .addConverterFactory(Fas)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(Integer.class, new TypeAdapter<Integer>() {
//            @Override
//            public void write(JsonWriter out, Integer value) throws IOException {
////                super.write(out, value);
//            }
//
//            @Override
//            public Integer read(JsonReader in) throws IOException {
//                return 222;
//            }
//        });
        return gsonBuilder.create();
    }


    Converter mConverter = new Converter<String, Object>() {
        @Override
        public Object convert(String value) throws IOException {
            return null;
        }
    };

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void test() {
        Api api = ApiManager.create().create(Api.class);
        api.login(100).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                        compositeDisposable.delete(d);
                        d.dispose();
                    }

                    @Override
                    public void onNext(@NonNull UserInfo userInfo) {
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    private void getDbDatas() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
