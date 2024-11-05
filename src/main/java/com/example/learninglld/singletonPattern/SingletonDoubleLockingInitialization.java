package com.example.learninglld.singletonPattern;

public class SingletonDoubleLockingInitialization {
    private static SingletonDoubleLockingInitialization instance;
    private SingletonDoubleLockingInitialization() {
        // Private constructor to prevent instantiation from outside the class
    }
    public static SingletonDoubleLockingInitialization getInstance() {
        if(instance == null) {
            synchronized (SingletonDoubleLockingInitialization.class) {
                if(instance == null) {
                    instance = new SingletonDoubleLockingInitialization();
                }
            }
        }
        return instance;
    }
}
