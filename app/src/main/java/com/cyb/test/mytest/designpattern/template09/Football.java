package com.cyb.test.mytest.designpattern.template09;

/**
 * 足球
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Football startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Football endPlay");
    }
}
