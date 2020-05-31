package com.practice.designpatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservable implements Observable<String> {
    private List<Observer<String>> observers = new ArrayList<>();

    @Override
    public void register(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String s) {
        observers.forEach(observer -> observer.receiveNotification(s));
    }
}
