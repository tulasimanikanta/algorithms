package com.practice.designpatterns.Observer;

public class ConcreteObserver implements Observer<String> {

    ConcreteObserver(Observable<String> observable) {
        observable.register(this);
    }
    @Override
    public void receiveNotification(String s) {
        System.out.println("received notification : " + s);
    }
}
