package com.cyb.test.mytest.producerconsumer;

/**
 * Created by Administrator on 2017/8/6.
 */

public class Product {
    public int id;

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "产品：" + id;
    }
}
