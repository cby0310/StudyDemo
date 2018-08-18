package com.cyb.test.mytest.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.cyb.test.mytest.R;

import java.util.List;


public class AidlTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test2);

        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, MyServiceConn, Context.BIND_AUTO_CREATE);

        startService(intent);
        startActivityForResult(intent, RESULT_OK);

    }

    private ServiceConnection MyServiceConn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager iBookManager = IBookManager.Stub.asInterface(service);
            try {
                iBookManager.addListener(listener);

                iBookManager.addBook(new Book("语文", 12));

                List<Book> books = iBookManager.getBookList();
                Log.e("TAG", "所有book:" + books.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(AidlTestActivity.this, "aa", Toast.LENGTH_LONG).show();
        }
    };


    private IOnNewBookArrivedListener listener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book book) throws RemoteException {
            Log.e("TAG", "添加了book：" + book.toString());
        }
    };
}
