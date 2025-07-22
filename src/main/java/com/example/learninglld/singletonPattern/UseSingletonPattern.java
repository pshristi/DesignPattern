package com.example.learninglld.singletonPattern;

public class UseSingletonPattern {
    public static void useSingletonPattern() {
        //Eager initialization
        SingletonEagerInitialization eagerInstance = SingletonEagerInitialization.getInstance();

        // Lazy initialization
        SingletonLazyInitialization lazyInstance = SingletonLazyInitialization.getInstance();

        //Synchronized initialization
        SingletonSynchronizedInitialization synchronizedInstance = SingletonSynchronizedInitialization.getInstance();

        //Double Locking initialization
        SingletonDoubleLockingInitialization doubleLockingInstance = SingletonDoubleLockingInitialization.getInstance();
    }
}
