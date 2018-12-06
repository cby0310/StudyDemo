package com.cyb.test.mytest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class BroadcastReceiverA extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Terry", "BroadcastReceiverA 收到了广播:" + intent.getStringExtra("key"));
        intent.putExtra("key", "changed");


        if (isOrderedBroadcast()) {
            Bundle bundle = new Bundle();
            bundle.putString("extra", "ddddd");
            setResultExtras(bundle);
            abortBroadcast();
        }
    }
}
