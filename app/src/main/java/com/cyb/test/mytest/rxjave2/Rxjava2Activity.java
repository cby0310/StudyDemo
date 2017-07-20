package com.cyb.test.mytest.rxjave2;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import com.cyb.test.mytest.MainActivity;
import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;
import com.cyb.test.mytest.aa;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class Rxjava2Activity extends AppCompatActivity {

    private static final String TAG = "Terry";

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);
//        demo2();

        Button button = (Button) findViewById(R.id.button);
        button.post(new MyRunnable("s") {
            @Override
            public void run() {
                MyLog.e("post运行线程：" + Thread.currentThread().getName());
            }
        });
//        button.post(() -> MyLog.e("post运行线程：" + Thread.currentThread().getName()));
    }

    class MyRunnable implements Runnable {

        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {

        }
    }


    Subscription mSubscription;

    public void request(View view) {
//        mSubscription.request(95);
        startActivity(new Intent(Rxjava2Activity.this, MainActivity.class));
    }


    public void demo4() {
        Flowable
                .create(new FlowableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                        Log.d(TAG, "First requested = " + emitter.requested());
                        boolean flag;
                        for (int i = 0; ; i++) {
                            emitter.onNext(i);
                            Log.d(TAG, "emit " + i + " , requested = " + emitter.requested());
                        }
                    }
                }, BackpressureStrategy.LATEST)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        mSubscription = s;
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void demo2() {
        Flowable
                .create(new FlowableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(final FlowableEmitter<Integer> emitter) throws Exception {
                        Log.d(TAG, "before emit, requested = " + emitter.requested());

                        Log.d(TAG, "emit 1");
                        emitter.onNext(1);
                        Log.d(TAG, "after emit 1, requested = " + emitter.requested());

                        Log.d(TAG, "emit 2");
                        emitter.onNext(2);
                        Log.d(TAG, "after emit 2, requested = " + emitter.requested());

                        Log.d(TAG, "emit 3");
                        emitter.onNext(3);
                        Log.d(TAG, "after emit 3, requested = " + emitter.requested());

                        Log.d(TAG, "emit complete");
                        emitter.onComplete();

                        Log.d(TAG, "after emit complete, requested = " + emitter.requested());
                    }
                }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                        s.request(2);   //request 2
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    //�첽��̽��ˮ�״�С
    public static void demo3() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "current requested: " + emitter.requested());
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void test1() {

        Flowable.just("Hello").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                aa.e(s);
            }
        });


        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                aa.e("Observable�����߳�" + Thread.currentThread().getName());

                e.onNext("1");
                e.onNext("2");
                e.onComplete();
                e.onNext("3");
            }
        });

        Observer<String> observer = new Observer<String>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
//                d.dispose();
                disposable = d;
                aa.e("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                aa.e("onNext  " + s);
                if (s.equals("20")) {
                    disposable.dispose();//丢弃之后，上游会继续发，但是下游不再接收�??
                    aa.e("dispose");
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                aa.e("onError   " + e.toString());
            }

            @Override
            public void onComplete() {
                aa.e("onComplete");
            }
        };

        observable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        aa.e("Observer�����߳�  " + Thread.currentThread().getName());
                        aa.e("accept1 = " + s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        aa.e("Observer�����߳�  " + Thread.currentThread().getName());
                        aa.e("accept2 = " + s);
                    }
                })
                .subscribe(observer);
    }


    private void testFlowable() {
        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                emitter.requested();//���ֵ����������εĴ������������ε���request(n)
                // �����������Ĵ�������������ÿ����һ��next�¼�֮��requested�ͼ�1��ע����next�¼���complete��error
                // �¼���������requested��������0
                // ʱ�����������û�д��������ˣ����ʱ����������������¼�����MissingBackpressureException

                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "emit 2");
                emitter.onNext(2);
                Log.d(TAG, "emit 3");
                emitter.onNext(3);
                Log.d(TAG, "emit complete");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR); //������һ������

        Subscriber<Integer> downstream = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe");
//                s.request(Long.MAX_VALUE);  //ע��������,
// ����û�У�ͬ����������ξ��׳�һ��������MissingBackpressureException�쳣,
// ��������û���յ��κ�������¼����첽�������
//                ���ο����������ͣ������β�����ֵ������ҵ����ͺ�δ�������������128��Ҳ�����쳣����Ϊˮ�״�СΪ128
// Flowable����Ƶ�ʱ�������һ���µ�˼·Ҳ������Ӧʽ��ȡ�ķ�ʽ�����õĽ�����������ٲ����������, ������֮ǰ�����Ŀ��������Ϳ����ٶȲ�̫һ��,
// ���ַ�ʽ��ͨ���׶��Ļ���˵�ͺñ���Ҷ�ʴ����,
// ���ǰ����ο���С�ձ�, �����ε���Ҷ��, ������Subscription.request(1)ʱ, Ҷ�ʾ�˵��Ҫ��һ��! Ȼ��С�ձ����ó�һ�����Ӹ�Ҷ��, ������,
// ��Ҷ�ʴ����������֮��, �ٴε���request(10),
// Ҷ�ʾ���˵��Ҫ��ʮ��!Ȼ��С�ձ����ɳ�ʮ�����Ӹ�Ҷ��, Ȼ����ڱ��Ͽ�����, ��Ҷ���ܲ��ܴ���ʮ������, ��Ҷ�ʴ���ʮ�����Ӻ��ټ���Ҫ���ӽ��Ŵ�
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.w(TAG, "onError: ", t);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
        upstream.subscribe(downstream);
    }


    private void testInterval() {
        Flowable.interval(1, TimeUnit.MICROSECONDS)
                .onBackpressureDrop()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.d(TAG, "onSubscribe");
//                        mSubscription = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "onNext: " + aLong);
                        try {
                            Thread.sleep(1000);  //��ʱ1��
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    private void testFull() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {  //����ѭ�������¼�
                    emitter.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io())
                .sample(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "" + integer);
                    }
                });
    }

    private void testBackPressure() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; ; i++) {   //����ѭ�����¼�
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
                Log.e(TAG, s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.w(TAG, throwable);
            }
        });
    }
}
