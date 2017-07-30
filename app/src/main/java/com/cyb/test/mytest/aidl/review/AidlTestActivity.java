package com.cyb.test.mytest.aidl.review;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;

import java.util.List;

public class AidlTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test);
        bindTest();
    }


    void bindTest() {
        Intent intent = new Intent(this, AppleManagerService.class);
        bindService(intent, new MyServiceConnection(), BIND_AUTO_CREATE);
    }

    IAppleManager iAppleManager = null;


    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iAppleManager = IAppleManager.Stub.asInterface(service);
            try {
                iAppleManager.addAppleArrivedListener(listener);
                iAppleManager.addAppleArrivedListener(listener);
                iAppleManager.addAppleArrivedListener(listener);

                List<Apple> apples = iAppleManager.getApples();
                MyLog.e(Thread.currentThread() + "   apples：" + apples.toString());

                iAppleManager.addApple(new Apple(10));
                apples = iAppleManager.getApples();
                MyLog.e(Thread.currentThread() + "   apples：" + apples.toString());


                iAppleManager.removeAppleArrivedListener(listener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    private IOnAppleArrivedListener listener = new IOnAppleArrivedListener.Stub() {
        @Override
        public void onAppleArrived(Apple apple) throws RemoteException {
            MyLog.e("监听者回调时的线程：" + Thread.currentThread());
            MyLog.e("如果有UI操作要切换到主线程中去额~!");
            MyLog.e("监听到添加了apple：" + apple.toString());
        }
    };
}
