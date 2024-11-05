package com.example.learninglld.singletonPattern;

public class SingletonSynchronizedInitialization {
    private static SingletonSynchronizedInitialization instance;
    private SingletonSynchronizedInitialization() {
        // Private constructor to prevent instantiation from outside the class
    }
    public static synchronized SingletonSynchronizedInitialization getInstance() {
        if(instance == null) {
            instance = new SingletonSynchronizedInitialization();
        }
        return instance;
    }
}
