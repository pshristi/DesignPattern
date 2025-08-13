# Adapter Pattern

## Definition
The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate. It acts as a bridge between two incompatible interfaces by wrapping an instance of one class into an adapter class that presents the expected interface.

## When to Use
- When you want to use an existing class, but its interface doesn't match the one you need
- When you want to create a reusable class that cooperates with classes that don't necessarily have compatible interfaces
- When you need to use several existing subclasses but it's impractical to adapt their interface by subclassing every one

## Components
1. **Target Interface**: The interface that clients expect or use
2. **Adaptee**: The existing class with the incompatible interface
3. **Adapter**: The class that implements the target interface and translates client requests to the adaptee

## How It Works
1. The client makes a request to the adapter by calling a method from the target interface
2. The adapter translates that request into one or more calls to the adaptee using the adaptee's interface
3. The client receives the results of the call and is unaware of the adapter's presence

## Example Implementation in This Project

### Target Interface (MyWeightMachineAdapter.java)
```java
public interface MyWeightMachineAdapter {
    int getWeightInKgs();
}
```

### Adaptee Interface (MyWeightMachine.java)
```java
public interface MyWeightMachine {
    int getWeightInPounds();
}
```

### Adaptee Implementation (MyWeightmachineImpl.java)
```java
public class MyWeightmachineImpl implements MyWeightMachine {
    public MyWeightmachineImpl() {
    }
    @Override
    public int getWeightInPounds() {
        return 42;
    }
}
```

### Adapter Implementation (MyWeightMachineAdapterImpl.java)
```java
public class MyWeightMachineAdapterImpl implements MyWeightMachineAdapter {
    private MyWeightMachine myWeightmachine;
    
    public MyWeightMachineAdapterImpl(MyWeightMachine myWeightmachine) {
        this.myWeightmachine = myWeightmachine;
    }
    
    @Override
    public int getWeightInKgs() {
        int weightInPounds = myWeightmachine.getWeightInPounds();
        return weightInPounds * 2; // Simple conversion for demonstration (in reality, should be * 0.45359237)
    }
}
```

### Client Usage (adapterPatternUsage.java)
```java
public class adapterPatternUsage {
    public static void useAdapterPattern() {
        MyWeightMachineAdapter myWeightMachineAdapter = new MyWeightMachineAdapterImpl(new MyWeightmachineImpl());
        System.out.println("Weight in kgs: " + myWeightMachineAdapter.getWeightInKgs());
    }
}
```

## Explanation of the Example
In this example:

1. **Target Interface**: `MyWeightMachineAdapter` with the method `getWeightInKgs()`
2. **Adaptee**: `MyWeightMachine` with the method `getWeightInPounds()`
3. **Adapter**: `MyWeightMachineAdapterImpl` which implements `MyWeightMachineAdapter` and contains a reference to `MyWeightMachine`

The client code wants to get weight in kilograms, but the existing weight machine only provides weight in pounds. The adapter bridges this gap by:

1. Taking a `MyWeightMachine` instance in its constructor
2. Implementing the `getWeightInKgs()` method that clients expect
3. Internally calling the adaptee's `getWeightInPounds()` method
4. Converting the result from pounds to kilograms (multiplying by 2 in this simplified example)

The client code can now work with the weight machine as if it natively supported kilograms, without having to modify either the client code or the original weight machine class.

## Benefits of the Adapter Pattern
- **Separation of Concerns**: The client code is separated from the implementation details of the adaptee
- **Open/Closed Principle**: You can introduce new adapters without breaking existing code
- **Single Responsibility Principle**: You can separate the interface conversion code from the primary business logic
- **Reusability**: You can reuse existing classes that lack compatible interfaces

## Real-World Analogies
- Power plug adapters that allow you to use devices from different countries
- Card readers that connect memory cards to a computer
- Language translators who help people speaking different languages communicate
