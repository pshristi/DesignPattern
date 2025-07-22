package com.example.learninglld.singletonPattern;

public class SingletonEagerInitialization {
    private static SingletonEagerInitialization instance = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static SingletonEagerInitialization getInstance() {
        return instance;
    }
}
