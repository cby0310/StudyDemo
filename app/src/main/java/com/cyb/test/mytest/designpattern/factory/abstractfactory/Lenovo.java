package com.cyb.test.mytest.designpattern.factory.abstractfactory;

/**
 * Created by pc on 2017/9/25.
 */

public class Lenovo implements ComputerInterface{
    @Override
    public void print() {
        System.err.print("Lenovo");
    }
}
