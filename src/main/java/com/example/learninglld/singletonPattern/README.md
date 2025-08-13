# Singleton Pattern

## Overview
The Singleton Pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to it. This is useful when exactly one object is needed to coordinate actions across the system.

## Key Concepts
- **Single Instance**: The pattern restricts the instantiation of a class to a single object.
- **Global Access**: It provides a global point of access to that instance.
- **Lazy or Eager Initialization**: The instance can be created when the class is loaded or when it's first needed.
- **Thread Safety**: In multi-threaded environments, special care must be taken to ensure that only one instance is created.

## When to Use
- When exactly one instance of a class is needed to coordinate actions across the system
- When you want to control access to a shared resource, such as a database connection
- When you want to avoid creating multiple instances of resource-intensive objects
- When you need a global point of access to an object

## Implementation in This Package

This package demonstrates four different approaches to implementing the Singleton pattern:

### 1. Eager Initialization

In this approach, the instance is created when the class is loaded.

```java
public class SingletonEagerInitialization {
    private static SingletonEagerInitialization instance = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static SingletonEagerInitialization getInstance() {
        return instance;
    }
}
```

**Pros**:
- Thread-safe without requiring explicit synchronization
- Simple implementation

**Cons**:
- Instance is created even if it's never used
- May not be efficient if the singleton is resource-intensive

### 2. Lazy Initialization

In this approach, the instance is created only when it's first needed.

```java
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
```

**Pros**:
- Instance is created only when needed
- More efficient than eager initialization if the singleton is resource-intensive and not always needed

**Cons**:
- Not thread-safe
- Multiple threads could create multiple instances

### 3. Synchronized Initialization

In this approach, the instance is created only when it's first needed, and thread safety is ensured using the synchronized keyword.

```java
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
```

**Pros**:
- Thread-safe
- Instance is created only when needed

**Cons**:
- Performance overhead due to synchronization
- Every call to getInstance() is synchronized, even after the instance is created

### 4. Double-Checked Locking

In this approach, the instance is created only when it's first needed, and thread safety is ensured using double-checked locking.

```java
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
```

**Pros**:
- Thread-safe
- Instance is created only when needed
- Better performance than synchronized initialization because synchronization is only used when necessary

**Cons**:
- More complex implementation
- Requires careful implementation to avoid subtle bugs

### Usage Example

```java
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
```

## How It Works
1. The constructor of the singleton class is made private to prevent instantiation from outside the class.
2. A static method (usually named getInstance()) is provided to get the single instance.
3. The first time getInstance() is called, it creates a new instance of the class (if using lazy initialization).
4. Subsequent calls to getInstance() return the same instance.

## Benefits of the Singleton Pattern
1. **Controlled Access**: The singleton class encapsulates its instance and controls access to it.
2. **Reduced Namespace**: The pattern reduces the need for global variables.
3. **Flexibility**: The pattern allows for lazy initialization and thread safety.
4. **Single Instance**: The pattern ensures that a class has only one instance.

## Drawbacks of the Singleton Pattern
1. **Global State**: Singletons introduce global state, which can make testing and debugging more difficult.
2. **Tight Coupling**: Classes that use singletons are tightly coupled to them, which can make them harder to test and maintain.
3. **Concurrency Issues**: In multi-threaded environments, special care must be taken to ensure thread safety.
4. **Violation of Single Responsibility Principle**: The singleton class is responsible for both its primary functionality and ensuring that only one instance exists.

## Comparison with Other Patterns
- **Factory Method**: Both are creational patterns, but factory method creates different objects, while singleton ensures only one instance.
- **Builder**: Builder focuses on constructing complex objects step by step, while singleton ensures a single instance.
- **Prototype**: Prototype creates new objects by copying existing ones, while singleton ensures only one instance exists.

## Real-World Applications
- Database connection pools
- Logger classes
- Configuration managers
- Thread pools
- Caches
