package com.cyb.test.mytest.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cyb.test.mytest.R;


public class DbTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
//
//        UserDao dao = new UserDao(this);
//        dao.add(new User(23, "cyb"));
//        Log.e("Terry", dao.getUser().toString());

    }
}
