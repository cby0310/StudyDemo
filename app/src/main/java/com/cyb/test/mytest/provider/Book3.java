package com.cyb.test.mytest.provider;

import android.os.Parcel;
import android.os.Parcelable;

public class Book3 implements Parcelable {

    public int bookId;
    public String bookName;

    public Book3() {

    }

    public Book3(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(bookId);
        out.writeString(bookName);
    }

    public static final Parcelable.Creator<Book3> CREATOR = new Parcelable.Creator<Book3>() {
        public Book3 createFromParcel(Parcel in) {
            return new Book3(in);
        }

        public Book3[] newArray(int size) {
            return new Book3[size];
        }
    };

    private Book3(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }


    @Override
    public String toString() {
        return "Book3{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
