package com.cyb.test.mytest.aidl.review;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/7/30.
 */

public class Apple implements Parcelable {
    public String color;
    public int weight;
    public float price;

    @Override
    public String toString() {
        return "price：" + price;
    }

    public Apple(float price) {
        this.price = price;
    }

    public Apple() {
    }

    protected Apple(Parcel in) {
        color = in.readString();
        weight = in.readInt();
        price = in.readFloat();
    }

    public static final Creator<Apple> CREATOR = new Creator<Apple>() {
        @Override
        public Apple createFromParcel(Parcel in) {
            return new Apple(in);
        }

        @Override
        public Apple[] newArray(int size) {
            return new Apple[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(color);
        dest.writeInt(weight);
        dest.writeFloat(price);
    }
}
