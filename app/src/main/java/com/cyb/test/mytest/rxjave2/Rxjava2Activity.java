package com.cyb.test.mytest.rxjave2;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.InterruptedIOException;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class Rxjava2Activity extends AppCompatActivity {

    static {
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (throwable instanceof InterruptedIOException) {
                    MyLog.e("Io interrupted");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        testZip();
        findViewById(R.id.textView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testZip();
            }
        });
    }


    private void testZip() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                MyLog.e("emit 1");
                emitter.onNext(1);
                Thread.sleep(1000);

                MyLog.e("emit 2");
                emitter.onNext(2);
                Thread.sleep(1000);

                MyLog.e("emit 3");
                emitter.onNext(3);
                Thread.sleep(1000);

                MyLog.e("emit 4");
                emitter.onNext(4);
                Thread.sleep(1000);

                MyLog.e("emit complete1");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                MyLog.e("emit A");
                emitter.onNext("A");
                Thread.sleep(1000);

                MyLog.e("emit B");
                emitter.onNext("B");
                Thread.sleep(1000);

                MyLog.e("emit C");
                emitter.onNext("C");
//                Thread.sleep(1000);

                MyLog.e("emit complete2");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        DialogFragment dialogFragment = new DialogFragment();
        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                MyLog.e("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                MyLog.e("onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                MyLog.e("onError");
            }

            @Override
            public void onComplete() {
                MyLog.e("onComplete");
            }
        });
    }


    private void testFlowable() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("ss");
            }
        }, BackpressureStrategy.DROP).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void testBackPressure1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {   //无限循环发事件
                    emitter.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Thread.sleep(2000);
                        MyLog.e("" + integer);
                    }
                });
    }

    private void testBackPressure2() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {   //无限循环发事件
                    emitter.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("A");
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                MyLog.e(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                MyLog.e(throwable.toString());
            }
        });
    }

    private void test() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(i + "");
                }
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                MyLog.e("onSubscribe ");
            }

            @Override
            public void onNext(String value) {
                MyLog.e("onNext " + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(12);
                e.onError(null);
                e.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
}
