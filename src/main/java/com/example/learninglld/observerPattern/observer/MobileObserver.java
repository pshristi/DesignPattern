package com.example.learninglld.observerPattern.observer;

import com.example.learninglld.observerPattern.observable.IphoneObservable;
import com.example.learninglld.observerPattern.observable.Observable;

public class MobileObserver implements Observer {
    private Observable iphoneObservable;

    public MobileObserver(Observable iphoneObservable) {
        this.iphoneObservable = iphoneObservable;
    }

    @Override
    public void update() {
        System.out.println("MobileObserver notified, new iPhone value: ");
    }
}
