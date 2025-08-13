# State Design Pattern

## Overview
The State Design Pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. The object will appear to change its class. It's used when an object's behavior depends on its state, and it must change its behavior at runtime depending on that state.

## Key Concepts
- **Context**: The class that has a state and delegates state-specific behavior to the current state object.
- **State**: An interface or abstract class defining the methods that all concrete states must implement.
- **Concrete States**: Classes that implement the State interface and provide the behavior associated with a state of the context.

## When to Use
- When an object's behavior depends on its state, and it must change its behavior at runtime depending on that state
- When operations have large, multipart conditional statements that depend on the object's state
- When a class has many states and the transitions between these states are complex
- When you want to avoid using a large monolithic if-else or switch statement to determine behavior based on state

## Implementation in This Package

This package demonstrates the State pattern using a vending machine example:

### Components

#### Context
1. **VendingMachine.java**: The context class that maintains a reference to the current state and delegates state-specific behavior to it.
   ```java
   @Data
   public class VendingMachine {
       States vendingMachineState;
       List<Coin> coinList;
       Inventory inventory;
       
       VendingMachine() {
           this.coinList = new ArrayList<>();
           this.inventory = new Inventory(10);
           this.vendingMachineState = new IdleState();
       }
   }
   ```

#### State Interface
2. **States.java**: The interface that defines the methods all concrete states must implement.
   ```java
   public interface States {
       void clickOnInsertCoinButton(VendingMachine machine);
       void putCoins(VendingMachine machine, Coin coin);
       void clickOnSelectProductButton(VendingMachine machine);
       void selectProduct(VendingMachine machine, Integer productCode);
       void dispenseProduct(VendingMachine machine, Integer productCode);
       Coin getChangeMoney(VendingMachine machine, Integer totalAmount);
       Coin doFullRefund(VendingMachine machine);
   }
   ```

#### Concrete States
3. **IdleState.java**: Represents the state when the vending machine is idle (no coins inserted).
   ```java
   public class IdleState implements States {
       boolean isReadyToAccpet = false;
       
       // Constructor and methods implementation
       // In this state, the machine can accept coins but not dispense products
   }
   ```

4. **HasMoneyState.java**: Represents the state when the vending machine has coins inserted.
   ```java
   public class HasMoneyState implements States {
       boolean isReadyToSelectProduct = false;
       
       // Methods implementation
       // In this state, the machine can accept product selection but not more coins
   }
   ```

5. **DispenseState.java**: Represents the state when the vending machine is dispensing a product or refunding money.
   ```java
   public class DispenseState implements States {
       // Methods implementation
       // In this state, the machine dispenses products or refunds money
   }
   ```

#### Supporting Classes
6. **Coin.java**: An enum representing the different types of coins that can be used.
   ```java
   public enum Coin {
       QUARTER(25),
       DIME(10),
       NICKEL(5),
       PENNY(1);
       
       public Integer value;
       
       // Constructor and methods
   }
   ```

7. **Item.java**: A class representing an item in the vending machine.
   ```java
   @Data
   public class Item {
       Integer itemCode;
       Integer price;
       
       // Constructor
   }
   ```

8. **ItemShelf.java**: A class representing a shelf in the vending machine that holds an item.
   ```java
   @Data
   public class ItemShelf {
       Item item;
       boolean isAvailable;
       
       // Constructor
   }
   ```

9. **Inventory.java**: A class managing the inventory of items in the vending machine.
   ```java
   @Data
   public class Inventory {
       List<ItemShelf> itemShelfList;
       
       // Constructor and methods to add, remove, and get items
   }
   ```

## How It Works
1. The VendingMachine (context) maintains a reference to the current state object.
2. When a method is called on the VendingMachine, it delegates the call to the current state object.
3. Each state handles the method call differently and can transition the VendingMachine to a different state.
4. The VendingMachine's behavior changes as its state changes, without changing its class.

### State Transitions
- **IdleState → HasMoneyState**: When coins are inserted into the machine.
- **HasMoneyState → DispenseState**: When a product is selected (either to dispense the product or to refund money).
- **DispenseState → IdleState**: After dispensing a product or refunding money.

## Benefits of the State Pattern
1. **Single Responsibility Principle**: Each state encapsulates the behavior associated with a particular state of the context.
2. **Open/Closed Principle**: You can introduce new states without changing existing state classes or the context.
3. **Eliminates Conditional Statements**: Replaces large conditional statements with polymorphism.
4. **Improves Cohesion**: Related behavior is grouped into separate state classes.

## Drawbacks of the State Pattern
1. **Increased Number of Classes**: Can lead to a proliferation of classes if there are many states.
2. **State Transitions**: Can be hard to keep track of state transitions if they are spread across multiple state classes.
3. **Overhead**: Introduces additional objects (state objects) and indirection.

## Comparison with Other Patterns
- **Strategy**: Both patterns delegate behavior to other objects, but Strategy is typically set at creation time, while State can change at runtime.
- **Command**: Command encapsulates a request as an object, while State encapsulates state-dependent behavior.
- **Singleton**: State objects are often implemented as singletons if they don't have instance variables.

## Real-World Applications
- Vending machines
- Traffic lights
- Media players (playing, paused, stopped states)
- Order processing systems (new, paid, shipped, delivered states)
- Game development (character states like idle, walking, running, jumping)
