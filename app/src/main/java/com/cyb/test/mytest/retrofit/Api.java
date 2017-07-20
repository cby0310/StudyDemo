package com.cyb.test.mytest.retrofit;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/5/5.
 */

public interface Api {
    @GET
    Observable<UserInfo> login(@Query("id") int id);
}
