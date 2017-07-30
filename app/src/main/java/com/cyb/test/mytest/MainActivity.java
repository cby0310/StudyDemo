package com.cyb.test.mytest;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cyb.test.mytest.aidl.Book;
import com.cyb.test.mytest.aidl.BookManagerService;
import com.cyb.test.mytest.aidl.IBookManager;
import com.cyb.test.mytest.aidl.IOnNewBookArrivedListener;
import com.cyb.test.mytest.db.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Handler handler2 = new Handler();

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.e("Terry", "Handler.Callback handleMessage");
            return true;
        }
    }) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("Terry", "handleMessage");
        }
    };


    private class MyToast extends Toast {
        /**
         * Construct an empty Toast object.  You must call {@link #setView} before you
         * can call {@link #show}.
         *
         * @param context The context to use.  Usually your {@link Application}
         *                or {@link Activity} object.
         */
        public MyToast(Context context) {
            super(context);
        }


    }

    private MyThread myThread;

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        image = (ImageView) findViewById(R.id.image);

        Glide.with(this).load("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3794371817,2637991827&fm=58").asGif()
                .placeholder(R.mipmap.ic_launcher).into(image);

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                looper.quitSafely();
            }
        });

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread = new MyThread();
                myThread.start();
            }
        });


        Intent intent = new Intent(this, BookManagerService.class);
//        bindService(intent, MyServiceConn, Context.BIND_AUTO_CREATE);
//
//        startService(intent);
//        startActivityForResult(intent,RESULT_OK);

        UserDao dao = new UserDao(this);
//        dao.add(new User(23, "cyb"));
        Log.e("Terry", dao.getUser().toString());


        float widthPixels = getResources().getDisplayMetrics().widthPixels;
        float heightPixels = getResources().getDisplayMetrics().heightPixels;

        float desity = getResources().getDisplayMetrics().density;
        int densityDpi = getResources().getDisplayMetrics().densityDpi;
        float scaledDensity = getResources().getDisplayMetrics().scaledDensity;

        Log.e("Terry", desity + "  " + densityDpi + "  " + scaledDensity);
        Log.e("Terry", widthPixels + "  " + heightPixels);

    }

    private Looper looper;

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            handler.sendEmptyMessage(4);


//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.e("Terry", "handler.post");
//                    }
//                });
            Log.e("Terry", "。。。。。。");

            Looper.prepare();
            Toast.makeText(MainActivity.this, "ss", Toast.LENGTH_LONG).show();
            looper = Looper.myLooper();
            Log.e("Terry", "阻塞了，这一句下面的不会执行。");
            Looper.loop();
            Log.e("Terry", "解除阻塞。。。");
            Toast.makeText(MainActivity.this, "aaaaa", Toast.LENGTH_LONG).show();
            Log.e("Terry", "这一次不会阻塞。。。toast也不会出来");
            Looper.loop();
        }
    }

    //    Looper.prepare();
//    Toast.makeText(MainActivity.this, "ss", Toast.LENGTH_LONG).show();
//    looper = Looper.myLooper();
//    Log.e("Terry", "阻塞了，这一句下面的不会执行。");
//    Looper.loop();
//    Log.e("Terry", "解除阻塞。。。");
//    Toast.makeText(MainActivity.this, "aaaaa", Toast.LENGTH_LONG).show();
//    Log.e("Terry", "这一次不会阻塞。。。toast也不会出来");
//    Looper.loop();
//   子线程中Looper.loop();方法会将这个线程阻塞，下面的语句就不会走了，调用quit()方法可解除，解除后再次调用loop是无效的，会立即返回。不建议子线程中Toast。但是主线程中为什么没有阻塞呢？
//
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
            Toast.makeText(MainActivity.this, "aa", Toast.LENGTH_LONG).show();
        }
    };


    private IOnNewBookArrivedListener listener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book book) throws RemoteException {
            Log.e("TAG", "添加了book：" + book.toString());
        }
    };
}
