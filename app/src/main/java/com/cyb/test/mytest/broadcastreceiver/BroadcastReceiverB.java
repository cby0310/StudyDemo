package com.cyb.test.mytest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverB extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Terry", "BroadcastReceiverB 收到了广播" + intent.getStringExtra("key"));
        if (isOrderedBroadcast())
            Log.e("Terry", getResultExtras(true).getString("extra"));

    }
}
