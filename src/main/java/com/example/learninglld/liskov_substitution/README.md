# Liskov Substitution Principle

## Overview
The Liskov Substitution Principle (LSP) is one of the five SOLID principles of object-oriented programming. It states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, a subclass should extend the capabilities of the parent class, not restrict them.

## Key Concepts
- **Substitutability**: Subtypes must be completely substitutable for their base types.
- **Behavioral Subtyping**: Subclasses should preserve the behavior expected by clients of the superclass.
- **Contract**: Subclasses must adhere to the "contract" established by the superclass.
- **Preconditions**: Subclasses cannot strengthen preconditions.
- **Postconditions**: Subclasses cannot weaken postconditions.
- **Invariants**: Subclasses must preserve invariants of the superclass.

## When to Apply
- When designing class hierarchies
- When implementing interfaces
- When using polymorphism
- When extending existing code
- When creating frameworks or libraries that others will extend

## Implementation in This Package

This package demonstrates both adherence to and violation of the Liskov Substitution Principle:

### Components
1. **Vehicle.java**: An interface defining the contract for vehicles.
   ```java
   public interface Vehicle {
       public Integer getWheels();
       public Boolean hasEngine();
   }
   ```

2. **Car.java**: A class that correctly implements the Vehicle interface.
   ```java
   public class Car implements Vehicle {
       @Override
       public Integer getWheels() {
           return 4;
       }

       @Override
       public Boolean hasEngine() {
           return true;
       }
   }
   ```

3. **Bicycle.java**: A class that violates the Liskov Substitution Principle.
   ```java
   public class Bicycle implements Vehicle {
       @Override
       public Integer getWheels() {
           return 2;
       }

       @Override
       public Boolean hasEngine() {
           return null;  // Violation of LSP
       }
   }
   ```

4. **VehicleUsage.java**: A class that demonstrates the problem caused by the LSP violation.
   ```java
   public static void useVehicle() {
       List<Vehicle> vehicles = new ArrayList<>();
       vehicles.add(new Car());
       vehicles.add(new Bicycle());

       for (Vehicle vehicle : vehicles) {
           // This will cause a NullPointerException when vehicle is a Bicycle
           System.out.println(vehicle.hasEngine().toString());
       }
   }
   ```

## LSP Violation Explained
In this example, the Bicycle class violates the Liskov Substitution Principle by returning `null` from the `hasEngine()` method instead of a Boolean value. This breaks the contract established by the Vehicle interface, which promises that `hasEngine()` will return a Boolean.

When the `useVehicle()` method tries to call `toString()` on the result of `hasEngine()`, it will work fine for Car objects but will throw a NullPointerException for Bicycle objects. This demonstrates how a violation of LSP can break code that depends on the contract of the supertype.

## Correct Implementation
A correct implementation of the Bicycle class would return a Boolean value from `hasEngine()`, like this:
```java
@Override
public Boolean hasEngine() {
    return false;  // Bicycles don't have engines
}
```

## Benefits of Following LSP
1. **Code Reusability**: Code written for the superclass can be reused with subclasses.
2. **Maintainability**: Changes to the superclass don't break subclass behavior.
3. **Polymorphism**: Objects can be treated uniformly through their base type.
4. **Testability**: Tests written for the superclass can be applied to subclasses.
5. **Flexibility**: New subclasses can be added without changing existing code.

## Drawbacks of Violating LSP
1. **Runtime Errors**: Unexpected behavior or exceptions at runtime.
2. **Fragile Code**: Code becomes brittle and prone to breaking when modified.
3. **Reduced Reusability**: Code written for the superclass can't be safely used with subclasses.
4. **Maintenance Burden**: Requires special handling for different subtypes.
5. **Violated Expectations**: Clients of the code can't rely on the expected behavior.

## Comparison with Other SOLID Principles
- **Single Responsibility Principle (SRP)**: While SRP focuses on a class having only one reason to change, LSP focuses on the relationship between types in a hierarchy.
- **Open/Closed Principle (OCP)**: LSP supports OCP by allowing new functionality to be added through subclassing without modifying existing code.
- **Interface Segregation Principle (ISP)**: ISP can help prevent LSP violations by ensuring interfaces are cohesive and focused.
- **Dependency Inversion Principle (DIP)**: DIP works with LSP to enable flexible, maintainable code by depending on abstractions rather than concrete implementations.

## Real-World Applications
- Framework design
- Plugin architectures
- API design
- Database access layers
- UI component hierarchies
- Event handling systems
