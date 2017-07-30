package com.cyb.test.mytest.aidl.review;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;

import com.cyb.test.mytest.MyLog;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppleManagerService extends Service {

    private CopyOnWriteArrayList<Apple> apples;
    private CopyOnWriteArrayList<IOnAppleArrivedListener> listeners;//这个就不行了，因为跨进程实际上就是对象的序列化和反序列化，穿过来之后对象就不是同一个了

    private RemoteCallbackList<IOnAppleArrivedListener> listenerRemoteCallbackList;

    public AppleManagerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyAppleBinder();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        apples = new CopyOnWriteArrayList<>();
        apples.add(new Apple(0));
        listeners = new CopyOnWriteArrayList<>();

        listenerRemoteCallbackList = new RemoteCallbackList<>();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    class MyAppleBinder extends IAppleManager.Stub {

        @Override
        public void addApple(Apple apple) throws RemoteException {
            apples.add(apple);
//            for (IOnAppleArrivedListener listener : listeners) {
//                listener.onAppleArrived(apple);
//            }

            int N = listenerRemoteCallbackList.beginBroadcast();
            for (int i = 0; i < N; i++) {
                IOnAppleArrivedListener listener = listenerRemoteCallbackList.getBroadcastItem(i);
                if (listener != null) {
                    listener.onAppleArrived(apple);
                }
            }
            listenerRemoteCallbackList.finishBroadcast();
        }

        @Override
        public List<Apple> getApples() throws RemoteException {
            SystemClock.sleep(1000000);
            return apples;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void addAppleArrivedListener(IOnAppleArrivedListener listener) throws RemoteException {
//            if (listeners.contains(listener)) {
//                MyLog.e("监听已经存在,无法再次添加");
//            } else {
//                listeners.add(listener);
//                MyLog.e("监听已添加");
//            }
            int N = listenerRemoteCallbackList.getRegisteredCallbackCount();
            MyLog.e("添加之前数量：" + N);

            listenerRemoteCallbackList.register(listener);

            N = listenerRemoteCallbackList.getRegisteredCallbackCount();
            MyLog.e("添加之后数量：" + N);
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void removeAppleArrivedListener(IOnAppleArrivedListener listener) throws RemoteException {
//            if (listeners.contains(listener)) {
//                listeners.remove(listener);
//                MyLog.e("监听已移除");
//            } else {
//                MyLog.e("监听不存在，无法移除");
//            }


            int N = listenerRemoteCallbackList.getRegisteredCallbackCount();
            MyLog.e("移除之前数量：" + N);

            listenerRemoteCallbackList.unregister(listener);

            N = listenerRemoteCallbackList.getRegisteredCallbackCount();
            MyLog.e("移除之后数量：" + N);
        }
    }
}
