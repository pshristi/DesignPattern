# Template Method Pattern

## Overview
The Template Method Pattern is a behavioral design pattern that defines the skeleton of an algorithm in a method in a base class, deferring some steps to subclasses. It lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

## Key Concepts
- **Abstract Class**: Contains the template method and abstract methods that subclasses must implement.
- **Template Method**: Defines the skeleton of an algorithm, calling abstract and concrete methods in a specific order.
- **Concrete Methods**: Methods with default implementation in the abstract class.
- **Abstract Methods**: Methods that must be implemented by subclasses.
- **Hook Methods**: Optional methods with default (often empty) implementation that subclasses can override if needed.

## When to Use
- When you want to let clients extend only particular steps of an algorithm, but not the whole algorithm or its structure
- When you have several classes that contain almost identical algorithms with some minor differences
- When you want to control the points at which subclasses can extend your algorithm
- When you want to avoid code duplication by moving common behavior to a single class

## Implementation in This Package

This package demonstrates the Template Method pattern using a payment processing example:

### Components

1. **Payment.java**: The abstract class that defines the template method and abstract methods.
   ```java
   abstract class Payment {
       abstract void validateRequest();
       abstract void debitAmount();
       abstract void debitGatewayCharges();
       abstract void creditAmount();
   
       public final void sendMoney() {
           validateRequest();
           debitAmount();
           debitGatewayCharges();
           creditAmount();
       }
   }
   ```

2. **MerchantPayment.java**: A concrete implementation for merchant payments.
   ```java
   public class MerchantPayment extends Payment {
       @Override
       void validateRequest() {
           // Implement validation logic for merchant payments
       }
   
       @Override
       void debitAmount() {
           // Implement debiting logic for merchant payments
       }
   
       @Override
       void debitGatewayCharges() {
           // Implement debiting gateway charges for merchant payments
       }
   
       @Override
       void creditAmount() {
           // Implement crediting logic for merchant payments
       }
   }
   ```

3. **PeerToPeerPayment.java**: A concrete implementation for peer-to-peer payments.
   ```java
   public class PeerToPeerPayment extends Payment {
       @Override
       void validateRequest() {
           // Implement validation logic for Peer to Peer payment
       }
   
       @Override
       void debitAmount() {
           // Implement debiting logic for Peer to Peer payment
       }
   
       @Override
       void debitGatewayCharges() {
           return; // No gateway charges for Peer to Peer payment
       }
   
       @Override
       void creditAmount() {
           // Implement crediting logic for Peer to Peer payment
       }
   }
   ```

4. **UseTemplateMethodPattern.java**: A client class that demonstrates how to use the Template Method pattern.
   ```java
   public class UseTemplateMethodPattern {
       public static void useTemplateMethodPattern() {
           Payment payment = new MerchantPayment();
           payment.sendMoney();
   
           Payment payment2 = new PeerToPeerPayment();
           payment2.sendMoney();
       }
   }
   ```

## How It Works
1. The client creates an instance of a concrete payment class (MerchantPayment or PeerToPeerPayment).
2. The client calls the template method (sendMoney()) on the payment object.
3. The template method executes the algorithm by calling the abstract methods in a specific order.
4. Each concrete payment class provides its own implementation of the abstract methods.
5. The algorithm's structure remains the same, but the behavior of individual steps can vary between different payment types.

## Benefits of the Template Method Pattern
1. **Code Reuse**: Common code is moved to the abstract class, reducing duplication.
2. **Control Over Algorithm**: The abstract class controls the overall algorithm structure.
3. **Flexibility**: Subclasses can provide different implementations of the steps without changing the algorithm's structure.
4. **Open/Closed Principle**: You can introduce new variants of the algorithm without modifying existing code.
5. **Inversion of Control**: The template method calls the subclass methods, not the other way around (Hollywood Principle: "Don't call us, we'll call you").

## Drawbacks of the Template Method Pattern
1. **Inheritance Limitations**: Some programming languages only support single inheritance, limiting the pattern's applicability.
2. **Complexity**: The pattern can make the code more complex and harder to understand.
3. **Maintenance**: Changes to the template method might require changes in all subclasses.
4. **Restrictive Skeleton**: The fixed algorithm structure might be too restrictive for some use cases.

## Comparison with Other Patterns
- **Strategy**: Both patterns address algorithm variations, but Template Method uses inheritance while Strategy uses composition.
- **Factory Method**: Factory Method is a specialization of Template Method where the factory method is the step that subclasses override.
- **Builder**: Both patterns can be used to construct complex objects, but Builder focuses on constructing an object step by step, while Template Method focuses on defining the steps of an algorithm.

## Real-World Applications
- Data processing pipelines with common steps but different implementations
- Document generation systems with common structure but different content
- Payment processing systems with different payment methods
- Game engines with common game loop but different game logic
- Web frameworks with common request handling but different business logic
- Testing frameworks with common test execution flow but different test cases
