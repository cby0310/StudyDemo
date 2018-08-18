package com.cyb.test.mytest.designpattern.observer05;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.cyb.test.mytest.R;

/**
 * Created by pc on 2017/11/25.
 */

public class AndroidCase extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //adapter更新数据就是一个观察者模式
        //ListView是观察者Observer，Adapter是被观察者Observable，多个观察者就是把一个adapter对象设置给了多少个ListView的情况
        //1.通知更新流程：adapter.notifyDataSetChanged() -> DataSetObservable(真正的被观察者)#notifyChanged() -> 遍历观察者Observer
        // (就是AdapterDataSetObserver，AbsListView的一个内部类，间接继承自DataSetObserver)#onChanged()重绘view视图
        //2.观察者由来：listView#setAdapter() -> mAdapter.registerDataSetObserver(mDataSetObserver) ->
        // BaseAdapter#registerDataSetObserver() -> mDataSetObservable.registerObserver(observer) ->
        // mObservers.add(observer)
        if (false) {
            BaseAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_aidl_test);
            ListView listView = new ListView(this);
            listView.setAdapter(adapter);

            adapter.notifyDataSetChanged();
        }

        //BroadcastReceiver也是一个观察者模式
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("ACTION")) {

                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("ACTION"));
        registerReceiver(broadcastReceiver, new IntentFilter("ACTION"));
        sendBroadcast(new Intent("ACTION"));

        unregisterReceiver(broadcastReceiver);
    }
}
