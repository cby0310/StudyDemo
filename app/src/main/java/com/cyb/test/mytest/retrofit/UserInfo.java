package com.cyb.test.mytest.retrofit;

/**
 * Created by Administrator on 2017/5/5.
 */

public class UserInfo implements Comparable {
    public int id;
    public String name;

    //
    @Override
    public boolean equals(Object o) {
        return id == id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        return -(name.length() - ((UserInfo) o).name.length());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
}
