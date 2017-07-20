// IOnNewBookArrivedListener.aidl
package com.cyb.test.mytest.aidl;
import com.cyb.test.mytest.aidl.Book;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book book);
}
