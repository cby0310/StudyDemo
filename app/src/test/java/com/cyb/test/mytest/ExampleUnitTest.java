package com.cyb.test.mytest;

import android.text.Editable;
import android.text.Spanned;

import com.cyb.test.mytest.retrofit.ApiManager;
import com.cyb.test.mytest.retrofit.OkHttpActivity;
import com.google.gson.Gson;

import org.junit.AfterClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 32);
//        objectFromData("aa", "null");
        System.err.println("addition_isCorrect");
    }


    @AfterClass
    public static void test() {
        System.err.println("after");
    }

    public String objectFromData(String str, String key) {
        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(str);
            return new com.google.gson.Gson().fromJson(jsonObject.getString(str), String.class);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {

    }

    @Test
    public void listTest() {
        List<Object> list = new ArrayList<Object>();
        list.add("ss");
        list.add(22);

        List<Editable> src = new ArrayList<>();//T Spannable
        List<Spanned> des = new ArrayList<>();
        copy(des, src);

        List<String> list1 = new ArrayList<>();
        List<? extends CharSequence> list2 = list1;

//        list2.add("ss");

    }

    class Bean<T extends String>

    {

    }

    @Test
    public void cloneTest() {
        ArrayList<Student> beans = new ArrayList<>();
        beans.add(new Student("xiaoming", 24));
        beans.add(new Student("xiaohua", 22));

        ArrayList<Student> beans2 = new ArrayList<>();
//        beans2 = beans;
        beans2.addAll(beans);
//        beans.get(0).name = "xiaoming111";
        beans.clear();

        Student student1 = new Student("xiaoming", 24);
        Student student2 = null;
        try {
            student2 = (Student) student1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        student1.age = 00;
//        beans = null;
//        beans.remove(1);
//        beans.clear();
//        beans.get(1) = null;

//        MyList myList = new MyList();

//        myList.get(8).age = 2;
//        System.err.println(myList.get(1) + "");

//        Student[] elementData = new Student[]{new Student("xiaoming", 24), new Student("xiaoming1", 241)};
//        elementData[1] = null;

//        System.err.println(elementData[1] + "");

        System.err.println(beans != null ? beans.toString() : "null");
        System.err.println(beans2 != null ? beans2.toString() : "null");
//        System.err.println(student1.toString());
//        System.err.println(student2.toString());
    }

    @Test
    public void testEnum() {
        BallTypeEnum ballTypeEnum = BallTypeEnum.BASKETBALL;
        boolean b = ballTypeEnum.equals(BallTypeEnum.BASKETBALL);
        System.out.println(b);
        ballTypeEnum.ordinal();

        System.out.println(BallTypeEnum.valueOf("BASKETBALL"));
        int com = ballTypeEnum.compareTo(BallTypeEnum.PINGPANGBAL);
        System.out.println(com);
    }


    @Test
    public void testGson() {
        ApiManager apiManager = new ApiManager();
        Gson gson = apiManager.getGson();
        int a = 9;
        String ss = "sssss";
        String s = gson.toJson(a);
        System.out.println(s);

        System.out.println(gson.fromJson(12 + "", Integer.class));
    }


    @Test
    public void rxTest() {
        new MyObservable().subscribe(new MyObserver());
    }

    class MyObservable extends Observable<String> {

        @Override
        protected void subscribeActual(Observer<? super String> observer) {

        }
    }

    class MyObserver implements Observer<String> {

        @Override
        public void onSubscribe(Disposable d) {
            d.dispose();
        }

        @Override
        public void onNext(String s) {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

    @Test
    public void okHttpTest() {
        new OkHttpActivity().okHttpTest();
    }

    static class Test2 {

        public static void main(String[] args) {
            /**不指定泛型的时候*/
            Object i = Test2.add(1 + "", 2); //这两个参数都是Integer，所以T为Integer类型
            Number f = Test2.add(1, 1.2);//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
            Object o = Test2.add(1, "asd");//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

            /**指定泛型的时候*/
            int a = Test2.<Integer>add(1, 2);//指定了Integer，所以只能为Integer类型或者其子类
//            int b = Test2.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float
            Number c = Test2.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
        }

        //这是一个简单的泛型方法
        public static <T> T add(T x, T y) {
            return y;
        }
    }

}