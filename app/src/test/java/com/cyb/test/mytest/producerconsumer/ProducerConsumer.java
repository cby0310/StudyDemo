package com.cyb.test.mytest.producerconsumer;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/6.
 */

public class ProducerConsumer {


    @Test
    public void main() {
        Storage s = new Storage();

        ExecutorService service = Executors.newFixedThreadPool(10);
        Producer p = new Producer("张三", s);
        Producer p2 = new Producer("李四", s);

        Consumer c = new Consumer("王五", s);
        Consumer c2 = new Consumer("老刘", s);
        Consumer c3 = new Consumer("老林", s);
        service.submit(p);
        //service.submit(p2);
        service.submit(c);
        service.submit(c2);
        service.submit(c3);
    }

}
