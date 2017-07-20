package com.cyb.test.mytest;

import com.cyb.test.mytest.retrofit.UserInfo;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test() {
        Pattern pattern = Pattern.compile("\\d{2}");
        Matcher matcher = pattern.matcher("0f3121122");
        boolean b = matcher.find();
        String group = matcher.group();


        int i = 0;
        while (matcher.find(i)) {
            System.out.print(matcher.group() + " ");
            i++;
        }
    }


    @Test
    public void format() {
        double a = 12.2345;
        String result = String.format("%.2f", a);
        System.err.println(result);

        System.err.println(new DecimalFormat("000.000").format(a));

        BigDecimal bigDecimal = new BigDecimal(a);
        double d2 = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        System.err.println(d2);
        System.err.println(" ".length());

    }

    @Test
    public void test1() {
//        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.just("Hello").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.err.println(s);
            }
        });


        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                System.err.println("Observable工作线程：" + Thread.currentThread().getName());

                e.onNext("1");
                System.err.println("发送了1");
                e.onNext("2");
                System.err.println("发送了2");
                e.onComplete();
                e.onNext("3");
                System.err.println("发送了3");
            }
        });

        Observer<String> observer = new Observer<String>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
//                d.dispose();
                disposable = d;
                System.err.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.err.println("Observer工作线程：" + Thread.currentThread().getName());
                System.err.println("onNext  " + s);
                if (s.equals("20")) {
                    disposable.dispose();//丢弃之后，上游会继续发，但是下游不再接收了
                    System.err.println("dispose 丢弃了");
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("onError   " + e.toString());
            }

            @Override
            public void onComplete() {
                System.err.println("onComplete");
            }
        };

        observable.subscribeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

//        observable.subscribe(new Consumer<String>() {
//            @Override
//            public void accept(@NonNull String s) throws Exception {
//                System.err.println("accept结果：" + s);
//            }
//        });

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.err.println("111");
//            }
//        };
//
//        Runnable runnable1 = () -> {
//            System.err.println("22222222");
//        };
//        runnable.run();
    }


    @Test
    public void mapTest() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        System.err.println("正在转换：" + integer + "");
                        return "转换了的结果：" + integer + "";
                    }
                })
                /*flatMap*/
                .concatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull String s) throws Exception {
                        List<String> list = new ArrayList<String>();
                        for (int i = 0; i < 3; i++) {
                            list.add("转换了 " + s);
                        }
                        return Observable.fromIterable(list).delay(10, TimeUnit.MICROSECONDS);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        System.err.println("accept：" + s + "");
                    }
                });
    }


    public void registerTest() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {

                    }
                })
                .observeOn(Schedulers.io())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(@NonNull String s) throws Exception {
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String stringObservableSource) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }


    private void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("");
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(""));
        bufferedWriter.write("");

        PrintWriter printWriter = new PrintWriter("");
        printWriter.print("ss");


    }

    @Test
    public void testSet() {
        boolean result;
        HashSet<UserInfo> set = new HashSet<>();

        UserInfo userInfo = new UserInfo();
        userInfo.name = "name1";
        result = set.add(userInfo);
        System.err.println(result);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.name = "name1233";
        result = set.add(userInfo2);
        System.err.println(result);

        TreeSet<UserInfo> treeSet = new TreeSet<>();
        treeSet.add(userInfo);
        treeSet.add(userInfo2);
//        userInfo2 = new UserInfo();
        userInfo2.id = 10;
        userInfo2.name = "name22";
        treeSet.add(userInfo2);

        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            UserInfo userInfo1 = (UserInfo) it.next();
            System.err.println(userInfo1.toString());
        }
    }

}