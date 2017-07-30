// IAppleManager.aidl
package com.cyb.test.mytest.aidl.review;

import com.cyb.test.mytest.aidl.review.Apple;
import com.cyb.test.mytest.aidl.review.IOnAppleArrivedListener;
// Declare any non-default types here with import statements

interface IAppleManager {
    void addApple(in Apple apple);

    List<Apple> getApples();


    void addAppleArrivedListener(in IOnAppleArrivedListener listener);
    void removeAppleArrivedListener(in IOnAppleArrivedListener listener);
}
