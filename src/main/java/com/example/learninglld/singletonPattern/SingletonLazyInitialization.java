package com.example.learninglld.singletonPattern;

public class SingletonLazyInitialization {
    private static SingletonLazyInitialization instance;
    private SingletonLazyInitialization() {
        // Private constructor to prevent instantiation from outside the class
    }
    public static SingletonLazyInitialization getInstance() {
        if(instance == null) {
            instance = new SingletonLazyInitialization();
        }
        return instance;
    }
}
