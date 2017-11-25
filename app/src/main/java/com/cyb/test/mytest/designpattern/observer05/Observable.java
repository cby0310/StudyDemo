package com.cyb.test.mytest.designpattern.observer05;

/**
 * Created by pc on 2017/11/25.
 */

public interface Observable<T> {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(T o);
}
