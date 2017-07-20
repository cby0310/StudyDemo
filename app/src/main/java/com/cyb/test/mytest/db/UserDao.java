package com.cyb.test.mytest.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2017/4/24.
 */

public class UserDao {

    DBHelper dbHelper;

    public UserDao(Context context) {
        dbHelper = DBHelper.getDBHelper(context);
    }

    public void add(User user) {
        SQLiteDatabase dbHelperReadableDatabase = dbHelper.getReadableDatabase();
        dbHelperReadableDatabase.execSQL("insert into student(age,name) values(20,'cyb')");
        dbHelperReadableDatabase.close();
    }

    public User getUser() {
        User user = new User();
        SQLiteDatabase dbHelperReadableDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelperReadableDatabase.rawQuery("select * from student where age  = ?", new String[]{"12"});
        if (cursor.moveToNext()) {
            user.age = cursor.getInt(0);
            user.name = cursor.getString(1);
        }
        dbHelperReadableDatabase.close();
        return user;
    }

}
