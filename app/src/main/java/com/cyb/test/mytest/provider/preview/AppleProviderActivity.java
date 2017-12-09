package com.cyb.test.mytest.provider.preview;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.cyb.test.mytest.R;


public class AppleProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_view);

        Uri appleUri = Uri.parse("content://com.cyb.appleprovider/apple1");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "insert");
        getContentResolver().insert(appleUri, contentValues);

        try {
            while (true) {
                oom();
            }
        } catch (OutOfMemoryError error) {
            Log.e("Terry", "ssssssssssssssssssssssss");
            Toast.makeText(this, "oom", Toast.LENGTH_SHORT).show();
            error.printStackTrace();
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void oom() {
        oom();
    }
}
