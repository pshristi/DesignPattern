package com.example.learninglld.observerPattern;

import com.example.learninglld.observerPattern.observable.IphoneObservable;
import com.example.learninglld.observerPattern.observable.Observable;
import com.example.learninglld.observerPattern.observer.MobileObserver;

public class Store {
    public void storeNotifyTest() {
        Observable iphone = new IphoneObservable();
        iphone.addObserver(new MobileObserver(iphone));
        iphone.addObserver(new MobileObserver(iphone));

        iphone.setValue(100);
    }
}
