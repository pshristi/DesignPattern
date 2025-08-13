# Strategy Pattern (Bridge Pattern)

## Overview
The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime. It defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern lets the algorithm vary independently from clients that use it.

The Bridge Pattern is a structural design pattern that separates an abstraction from its implementation so that the two can vary independently. While they serve different purposes, they have similar structures, which is why they are sometimes compared or confused.

## Key Concepts
- **Context**: The class that uses a Strategy and maintains a reference to a Strategy object.
- **Strategy Interface**: Defines a common interface for all concrete strategies.
- **Concrete Strategies**: Implement the Strategy interface, providing different implementations of the algorithm.

## When to Use
- When you want to define a family of algorithms and make them interchangeable
- When you need different variants of an algorithm
- When an algorithm uses data that clients shouldn't know about
- When a class has multiple behaviors that appear as multiple conditional statements

## Implementation in This Package

This package demonstrates the Strategy pattern using a vehicle example with two implementations:

### Without Strategy Pattern (`withoutStrategyPattern` package)

In this implementation:

1. **Vehicle.java**: Base class with a default drive() method.
   ```java
   public class Vehicle {
       public void drive() {
           System.out.println("Simple driving capability");
       }
   }
   ```

2. **PassengerVehicle.java**: Extends Vehicle without overriding any methods, inheriting the default behavior.
   ```java
   public class PassengerVehicle extends Vehicle {
   }
   ```

3. **SportsVehicle.java**: Extends Vehicle and overrides the drive() method.
   ```java
   public class SportsVehicle extends Vehicle {
       @Override
       public void drive() {
           //This is leading to duplicate code in OffroadVehicle and SportsVehicle classes
           System.out.println("Sports driving capability");
       }
   }
   ```

4. **OffroadVehicle.java**: Extends Vehicle and overrides the drive() method with the same implementation as SportsVehicle.
   ```java
   public class OffroadVehicle extends Vehicle {
       @Override
       public void drive() {
           //This is leading to duplicate code in OffroadVehicle and SportsVehicle classes
           System.out.println("Sports driving capability");
       }
   }
   ```

### With Strategy Pattern (`withStrategyPattern` package)

In this implementation:

1. **DrivingStrategy.java**: The strategy interface that defines the drive behavior.
   ```java
   public interface DrivingStrategy {
       void drive();
   }
   ```

2. **SimpleDrivingStrategy.java**: A concrete strategy for simple driving.
   ```java
   public class SimpleDrivingStrategy implements DrivingStrategy {
       @Override
       public void drive() {
           System.out.println("Simple driving capability");
       }
   }
   ```

3. **SportsDrivingStrategy.java**: A concrete strategy for sports driving.
   ```java
   public class SportsDrivingStrategy implements DrivingStrategy {
       @Override
       public void drive() {
           System.out.println("Sports driving capability");
       }
   }
   ```

4. **Vehicle.java**: The context class that uses a strategy.
   ```java
   public class Vehicle {
       DrivingStrategy drivingStrategy;

       public Vehicle(DrivingStrategy drivingStrategy) {
           this.drivingStrategy = drivingStrategy;
       }

       public void drive() {
           drivingStrategy.drive();
       }
   }
   ```

5. **PassengerVehicle.java**: Uses the SimpleDrivingStrategy.
   ```java
   public class PassengerVehicle extends Vehicle {
       PassengerVehicle() {
           super(new SimpleDrivingStrategy());
       }
   }
   ```

6. **SportsVehicle.java**: Uses the SportsDrivingStrategy.
   ```java
   public class SportsVehicle extends Vehicle {
       SportsVehicle() {
           super(new SportsDrivingStrategy());
       }
   }
   ```

7. **OffroadVehicle.java**: Also uses the SportsDrivingStrategy.
   ```java
   public class OffroadVehicle extends Vehicle {
       OffroadVehicle() {
           super(new SportsDrivingStrategy());
       }
   }
   ```

## How It Works
1. The client creates a vehicle object (PassengerVehicle, SportsVehicle, or OffroadVehicle).
2. Each vehicle type is initialized with the appropriate driving strategy.
3. When the client calls the vehicle's drive() method, the vehicle delegates to its driving strategy.
4. The concrete strategy executes its implementation of the drive() method.

## Benefits of the Strategy Pattern
1. **Eliminates Conditional Statements**: Replaces complex conditional logic with strategy objects.
2. **Reduces Code Duplication**: Common algorithms can be reused across different contexts.
3. **Encapsulation**: Each algorithm is encapsulated in its own class.
4. **Runtime Flexibility**: Algorithms can be switched at runtime.
5. **Open/Closed Principle**: New strategies can be added without modifying existing code.
6. **Separation of Concerns**: The context is separated from the implementation details of the algorithm.

## Drawbacks of the Strategy Pattern
1. **Increased Number of Objects**: Creates more objects in the system.
2. **Client Awareness**: Clients must be aware of different strategies.
3. **Communication Overhead**: Strategies might need to communicate with the context.
4. **Increased Complexity**: For simple cases, using the pattern might be overkill.

## Comparison with Other Patterns
- **Template Method**: Both patterns address algorithm variations, but Template Method uses inheritance while Strategy uses composition.
- **State**: Similar structure, but State represents the state of an object while Strategy represents an algorithm.
- **Command**: Command encapsulates a request as an object, while Strategy encapsulates an algorithm.
- **Bridge**: Both separate abstraction from implementation, but Bridge focuses on object structure while Strategy focuses on behavior.

## Real-World Applications
- Sorting algorithms (different strategies for different data types or performance requirements)
- Payment processing systems (different payment methods)
- Compression algorithms (different compression strategies)
- Navigation systems (different routing algorithms)
- Authentication systems (different authentication methods)
- Tax calculation systems (different tax calculation strategies for different regions)
