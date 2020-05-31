package com.practice.designpatterns.Observer;

public interface Observable<T> {
    void register(Observer<T> observer);
    void remove(Observer<T> observer);
    void notifyObservers(T t);
}
