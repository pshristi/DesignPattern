# Observer Pattern

## Overview
The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It is commonly used to implement distributed event handling systems.

## Key Components
1. **Observable (Subject)**: The object that is being observed. It maintains a list of observers and provides methods to add, remove, and notify observers.
2. **Observer**: The interface or abstract class that defines the update method that gets called when the Observable changes.
3. **ConcreteObservable**: A concrete implementation of the Observable interface.
4. **ConcreteObserver**: A concrete implementation of the Observer interface.

## Implementation Details

### Observable Interface
The `Observable` interface defines the contract for objects that can be observed:
```java
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setValue(int value);
    Integer getValue();
}
```

### IphoneObservable Implementation
The `IphoneObservable` class implements the `Observable` interface:
- It maintains a list of observers and a stock value
- When the stock value changes from 0 to a non-zero value, it notifies all observers
- It provides methods to add and remove observers

```java
public class IphoneObservable implements Observable {
    private Integer stockValue;
    private List<Observer> observers = new ArrayList<>();
    
    // Implementation of Observable methods
    // ...
}
```

### Observer Interface
The `Observer` interface defines the contract for objects that observe Observables:
```java
public interface Observer {
    void update();
}
```

### MobileObserver Implementation
The `MobileObserver` class implements the `Observer` interface:
- It has a reference to an Observable object
- When notified of a change, it prints a message

```java
public class MobileObserver implements Observer {
    private Observable iphoneObservable;
    
    // Constructor and implementation of update method
    // ...
}
```

### Usage Example
The `Store` class demonstrates how to use the Observer pattern:
```java
public class Store {
    public void storeNotifyTest() {
        Observable iphone = new IphoneObservable();
        iphone.addObserver(new MobileObserver(iphone));
        iphone.addObserver(new MobileObserver(iphone));

        iphone.setValue(100);
    }
}
```

## Benefits
1. **Loose Coupling**: The Observable doesn't need to know anything about the Observers, reducing dependencies.
2. **Broadcast Communication**: Changes to the Observable are broadcast automatically to all registered Observers.
3. **Flexibility**: Observers can be added or removed at runtime.

## Use Cases
1. Event management systems
2. Model-View-Controller (MVC) architecture
3. Subscription systems (like the iPhone stock notification example)
4. GUI components that need to update when data changes
