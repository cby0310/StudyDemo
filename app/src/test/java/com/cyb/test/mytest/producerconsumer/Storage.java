package com.cyb.test.mytest.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/8/6.
 */

public class Storage {
    LinkedBlockingDeque<Product> queues = new LinkedBlockingDeque<>(10);


    /**
     * 生产
     *
     * @param product
     */
    public void product(Product product) {
        queues.add(product);
    }

    /**
     * 消费
     */
    public Product consum() throws InterruptedException {
        return queues.take();
    }
}
