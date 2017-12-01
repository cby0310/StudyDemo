package com.cyb.test.mytest.designpattern.observer05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/11/25.
 */

public class ConcreteObservable implements Observable<String> {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(String s) {
        for (Observer o : observers) {
            o.update(s);
        }
    }
}
