package com.cyb.test.mytest.robo;

import android.content.SharedPreferences;

/**
 * Created by chaoyongbing on 2017/11/1 15:30.
 */

public class ShareDao {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public ShareDao(SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
        this.editor = sharedPref.edit();
    }

    public ShareDao() {
//        this(App.getContext().getSharedPreferences("myShare", Context.MODE_PRIVATE));
    }

    public void put(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String get(String key) {
        return sharedPref.getString(key, "");
    }

}
