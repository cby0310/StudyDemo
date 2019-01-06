package com.cyb.test.mytest.broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiverActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        setContentView(button);

        button.setText("发射广播");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastReceiverActivity.this.sendBroadcast(new Intent("android.intent.action.cyb"));
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                BroadcastReceiverActivity.this.sendBroadcast(new Intent("com.xxx.dynamic_br"));
                return true;
            }
        });


        IntentFilter intentFilter = new IntentFilter("android.intent.action.cyb");
        intentFilter.setPriority(12);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("Terry", "我是动态广播，应该先通知我:" + intent.getStringExtra("key"));
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);

    }

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
