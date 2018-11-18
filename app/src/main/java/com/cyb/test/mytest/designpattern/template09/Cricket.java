package com.cyb.test.mytest.designpattern.template09;

/**
 * 板球
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket startPlay");
    }
}
