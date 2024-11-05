package com.example.learninglld.observerPattern.observable;

import com.example.learninglld.observerPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable{
    private Integer stockValue;
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setValue(int value) {
        if(this.stockValue == 0){
            this.notifyObservers();
        }
        stockValue = value;
    }

    @Override
    public Integer getValue() {
        return stockValue;
    }
}
