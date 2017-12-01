package com.cyb.test.mytest;

/**
 * Created by chaoyongbing on 2017/11/10 10:38.
 */
public class Status {
    public Status START = new Status();
    public static Status RUNNING;
    public static Status STOP;

    static {
        RUNNING = new Status("b");
        STOP = new Status();
    }

    public Status() {
        this("def");
    }

    private Status(String name) {
        this.name = name;
    }

    public String name;
}