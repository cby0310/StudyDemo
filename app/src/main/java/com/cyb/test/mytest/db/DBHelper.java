package com.cyb.test.mytest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/4/24.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "db_t", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(age int,name varchar(20),primary key(age))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public static DBHelper getDBHelper(Context context) {
        DBHelper helper = null;
        if (helper == null) {
            synchronized (DBHelper.class) {
                if (helper == null) {
                    helper = new DBHelper(context);
                }
            }
        }
        return helper;
    }
}
