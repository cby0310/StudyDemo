package com.cyb.test.mytest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverA extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Terry", "BroadcastReceiverA 收到了广播:" + intent.getStringExtra("key"));
        Toast.makeText(context, "BroadcastReceiverA 收到了广播", Toast.LENGTH_LONG).show();
        intent.putExtra("key", "changed");

//        context.registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Log.e("Terry", "好厉害呀，我是插件中动态注册的广播");
//                Toast.makeText(context, "好厉害呀，我是插件中动态注册的广播", Toast.LENGTH_LONG).show();
//            }
//        }, new IntentFilter("com.xxx.dynamic_br"));
        context.registerReceiver(null, new IntentFilter("com.xxx.dynamic_br"));


        if (isOrderedBroadcast()) {
            Bundle bundle = new Bundle();
            bundle.putString("extra", "ddddd");
            setResultExtras(bundle);
            abortBroadcast();
        }
    }
}
