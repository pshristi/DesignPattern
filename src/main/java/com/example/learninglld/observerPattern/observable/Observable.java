package com.example.learninglld.observerPattern.observable;

import com.example.learninglld.observerPattern.observer.Observer;

public interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void setValue(int value);

    Integer getValue();
}
