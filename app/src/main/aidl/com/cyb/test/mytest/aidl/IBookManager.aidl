package com.cyb.test.mytest.aidl;
import com.cyb.test.mytest.aidl.Book;
import com.cyb.test.mytest.aidl.IOnNewBookArrivedListener;

interface IBookManager {
    List<Book> getBookList();

    void addBook(in Book book);

    void addListener(in IOnNewBookArrivedListener listener);
    void cancelListener(in IOnNewBookArrivedListener listener);
}
