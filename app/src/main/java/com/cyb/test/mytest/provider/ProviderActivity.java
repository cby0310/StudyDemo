package com.cyb.test.mytest.provider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;


public class ProviderActivity extends Activity {
    private static final String TAG = "ProviderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_android_case);
        // Uri uri = Uri.parse("content://com.ryg.chapter_2.book.com.provider");
        // getContentResolver().query(uri, null, null, null, null);
        // getContentResolver().query(uri, null, null, null, null);
        // getContentResolver().query(uri, null, null, null, null);
        Uri bookUri = Uri.parse("content://com.example.administrator.bookprovider/book/12");
        getContentResolver().registerContentObserver(bookUri, false, new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                MyLog.e("监听到数据变化了，" + uri);
            }
        });

        ContentValues values = new ContentValues();
        values.put("_id", 6);
        values.put("name", "程序设计的艺术");
        getContentResolver().insert(bookUri, values);

        Cursor bookCursor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        while (bookCursor.moveToNext()) {
            Book3 book = new Book3();
            book.bookId = bookCursor.getInt(0);
            book.bookName = bookCursor.getString(1);
            Log.d(TAG, "query book:" + book.toString());
        }
        bookCursor.close();

        Uri userUri = Uri.parse("content://com.example.administrator.bookprovider/user");
        Cursor userCursor = getContentResolver().query(userUri, new String[]{"_id", "name", "sex"}, null, null, null);
        while (userCursor.moveToNext()) {
            User user = new User();
            user.userId = userCursor.getInt(0);
            user.userName = userCursor.getString(1);
            user.isMale = userCursor.getInt(2) == 1;
            Log.d(TAG, "query user:" + user.toString());
        }
        userCursor.close();
    }
}
