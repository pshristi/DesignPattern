# Mediator Pattern

## Overview
The Mediator Pattern is a behavioral design pattern that defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly, allowing you to vary their interaction independently.

## Key Concepts
- **Mediator**: An interface or abstract class that defines the communication protocol between colleagues.
- **Concrete Mediator**: A class that implements the Mediator interface and coordinates communication between colleagues.
- **Colleague**: An interface or abstract class that defines the methods colleagues must implement.
- **Concrete Colleague**: A class that implements the Colleague interface and communicates with other colleagues through the mediator.

## When to Use
- When a set of objects communicate in well-defined but complex ways
- When reusing an object is difficult because it communicates with many other objects
- When behavior that's distributed between several classes should be customizable without a lot of subclassing
- When you want to reduce coupling between classes that communicate with each other

## Implementation in This Package

This package demonstrates the Mediator pattern using an auction system example:

### Components
1. **Mediator.java**: An interface defining the mediator's responsibilities.
   ```java
   public interface Mediator {
       void addBider(Colleague colleague);
       void placeBid(Colleague colleague, int bid);
   }
   ```

2. **AuctionMediator.java**: A concrete mediator that implements the Mediator interface.
   ```java
   public class AuctionMediator implements Mediator {
       private List<Colleague> bidders = new ArrayList<>();
       
       @Override
       public void addBider(Colleague colleague) {
           this.bidders.add(colleague);
       }
       
       @Override
       public void placeBid(Colleague colleague, int bid) {
           for (Colleague bidder : bidders) {
               if (!bidder.getName().equals(colleague.getName())) {
                   bidder.receiveBid(bid);
               }
           }
       }
   }
   ```

3. **Colleague.java**: An interface defining the methods colleagues must implement.
   ```java
   public interface Colleague {
       void placeBid(int amount);
       void receiveBid(int amount);
       String getName();
   }
   ```

4. **Auctioner.java**: A concrete colleague that implements the Colleague interface.
   ```java
   public class Auctioner implements Colleague {
       String name;
       AuctionMediator mediator;
       
       public Auctioner(String name, AuctionMediator mediator) {
           this.name = name;
           this.mediator = mediator;
           mediator.addBider(this);
       }
       
       @Override
       public void placeBid(int amount) {
           mediator.placeBid(this, amount);
       }
       
       @Override
       public void receiveBid(int amount) {
           System.out.println(name + " received bid of " + amount);
       }
       
       public String getName() {
           return name;
       }
   }
   ```

5. **UseMediator.java**: A client class that demonstrates how to use the Mediator pattern.
   ```java
   public static void useMediator() {
       AuctionMediator mediator = new AuctionMediator();
       Auctioner auctioner1 = new Auctioner("Alice", mediator);
       Auctioner auctioner2 = new Auctioner("Bob", mediator);
       
       auctioner1.placeBid(100);
       auctioner2.placeBid(200);
   }
   ```

## How It Works
1. The client creates an AuctionMediator.
2. The client creates Auctioner objects, passing the mediator to each.
3. When an auctioneer places a bid, it calls the mediator's placeBid() method.
4. The mediator notifies all other auctioneers about the bid by calling their receiveBid() method.
5. The auctioneers don't communicate directly with each other; all communication goes through the mediator.

## Benefits of the Mediator Pattern
1. **Reduced Coupling**: Objects communicate through the mediator rather than directly with each other.
2. **Single Responsibility Principle**: The mediator encapsulates the communication logic, keeping it separate from the business logic of the colleagues.
3. **Open/Closed Principle**: New colleagues can be added without modifying existing code.
4. **Reusability**: Colleagues are more reusable because they're not tightly coupled to other colleagues.
5. **Centralized Control**: Communication logic is centralized in the mediator, making it easier to understand and maintain.

## Drawbacks of the Mediator Pattern
1. **Complexity**: The mediator can become complex and hard to maintain if it handles too many responsibilities.
2. **God Object**: The mediator can evolve into a "god object" that knows too much and does too much.
3. **Performance**: Communication through a mediator might be less efficient than direct communication.

## Comparison with Other Patterns
- **Observer**: Both patterns facilitate communication between objects, but Observer is typically one-to-many, while Mediator is many-to-many.
- **Facade**: Both patterns abstract complexity, but Facade simplifies an interface to a subsystem, while Mediator coordinates interactions between objects.
- **Command**: Command can be used with Mediator to represent requests as objects that the mediator can handle.
- **Singleton**: The mediator is often implemented as a singleton to ensure a single point of coordination.

## Real-World Applications
- Chat applications (users communicate through a chat server)
- Air traffic control systems (planes communicate through the control tower)
- Event handling in GUI frameworks
- Message brokers in distributed systems
- Coordination in multi-player games
