package com.practice.designpatterns.Observer;

public class ObserverMain {
    public static void main(String[] args) {
        ConcreteObservable observable = new ConcreteObservable();
        ConcreteObserver observer1 = new ConcreteObserver(observable);
        ConcreteObserver observer2 = new ConcreteObserver(observable);
        ConcreteObserver observer3 = new ConcreteObserver(observable);
        observable.notifyObservers("test");
    }
}
