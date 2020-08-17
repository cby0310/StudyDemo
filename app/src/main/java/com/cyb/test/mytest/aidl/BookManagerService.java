package com.cyb.test.mytest.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookManagerService extends Service {

    private CopyOnWriteArrayList<Book> bookArrayList = new CopyOnWriteArrayList();
    private RemoteCallbackList<IOnNewBookArrivedListener> listeners = new RemoteCallbackList();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate");
        bookArrayList.add(new Book("android", 1000));
        bookArrayList.add(new Book("ios", 100));

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private IBinder mBinder = new IBookManagerCopy.Stub() {

        @Override
        public IBinder asBinder() {
            return super.asBinder();
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookArrayList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            bookArrayList.add(book);
            int size = listeners.beginBroadcast();

            for (int i = 0; i < size; i++) {
                listeners.getBroadcastItem(i).onNewBookArrived(book);
            }
            listeners.finishBroadcast();
        }

        @Override
        public void addListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (listeners.contains(listener)) {
//                Log.e("TAG", "已经有了");
//            } else {
            listeners.register(listener);
            int size = listeners.beginBroadcast();
            Log.e("TAG", "添加成功：" + size);
            listeners.finishBroadcast();
//            }
        }

        @Override
        public void cancelListener(IOnNewBookArrivedListener listener) throws RemoteException {
//            if (listeners.contains(listener)) {
            listeners.unregister(listener);
            int size = listeners.beginBroadcast();
            Log.e("TAG", "移除成功：" + size);
            listeners.finishBroadcast();
//            } else {
//                Log.e("TAG", "移除失败，不存在");
//            }
        }
    };
}
