package com.cyb.test.mytest.provider.preview;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.cyb.test.mytest.MyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/6/11.
 */

public class AppleProvider extends ContentProvider {
    private List<Apple> apples;
    private List<Apple> apples2;

    public static final String AUTHORITYAPPLE = "com.cyb.appleprovider";
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int APPLE_CODE1 = 0;
    private static final int APPLE_CODE2 = 1;

    static {
        sUriMatcher.addURI(AUTHORITYAPPLE, "apple1", APPLE_CODE1);
        sUriMatcher.addURI(AUTHORITYAPPLE, "apple2", APPLE_CODE2);
    }

    @Override
    public boolean onCreate() {
        apples = new ArrayList<>();
        apples2 = new ArrayList<>();
        apples.add(new Apple("1 apple1"));
        apples2.add(new Apple("2 apple1"));
        return true;//120
    }

    private List<Apple> getAppleArrayList(Uri uri) {
        List<Apple> list = null;
        switch (sUriMatcher.match(uri)) {
            case APPLE_CODE1:
                list = apples;
                break;
            case APPLE_CODE2:
                list = apples2;
                break;
        }
        return list;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable
            String[] selectionArgs, @Nullable String sortOrder) {
        List<Apple> list = getAppleArrayList(uri);
        list.get(0);

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        List<Apple> list = getAppleArrayList(uri);
        list.add(new Apple(values.getAsString("name")));
        MyLog.e("插入了一条数据");
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        List<Apple> list = getAppleArrayList(uri);
        list.remove(0);
        return list.size();
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable
            String[] selectionArgs) {
        List<Apple> list = getAppleArrayList(uri);
        list.remove(0);
        list.add(0, new Apple("update"));
        return list.size();
    }
}
