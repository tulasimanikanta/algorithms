package com.practice.designpatterns.Observer;

public interface Observer<T> {
    void receiveNotification(T t);
}
