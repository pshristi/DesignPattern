# Visitor Pattern

## Overview
The Visitor Pattern is a behavioral design pattern that allows you to separate algorithms from the objects on which they operate. It lets you define a new operation without changing the classes of the elements on which it operates. The pattern uses a technique called double dispatch, where the operation performed depends on both the type of visitor and the type of element it visits.

## Key Concepts
- **Element Interface**: Declares an `accept` method that takes a visitor as an argument.
- **Concrete Elements**: Implement the element interface and define the `accept` method.
- **Visitor Interface**: Declares a `visit` method for each concrete element type.
- **Concrete Visitors**: Implement the visitor interface and define the operations to be performed on elements.
- **Client**: Creates concrete visitor objects and passes them to elements via the `accept` method.

## When to Use
- When you need to perform operations on a complex object structure, such as a composite object
- When you need to add new operations to existing object structures without modifying those structures
- When related operations should be grouped together rather than spread across multiple classes
- When the object structure classes rarely change, but you often need to define new operations on them
- When you want to avoid polluting classes with operations that are only needed for specific purposes

## Implementation in This Package

This package demonstrates the Visitor pattern using a hotel room example:

### Components

1. **HotelElement.java**: The element interface that declares the accept method.
   ```java
   public interface HotelElement {
       void accept(HotelVisitor visitor);
   }
   ```

2. **SingleRoom.java**: A concrete element representing a single hotel room.
   ```java
   public class SingleRoom implements HotelElement {
       @Override
       public void accept(HotelVisitor visitor) {
           visitor.visit(this);
       }
   }
   ```

3. **DoubleRoom.java**: A concrete element representing a double hotel room.
   ```java
   public class DoubleRoom implements HotelElement {
       @Override
       public void accept(HotelVisitor visitor) {
           visitor.visit(this);
       }
   }
   ```

4. **HotelVisitor.java**: The visitor interface that declares visit methods for each element type.
   ```java
   public interface HotelVisitor {
       void visit(SingleRoom singleRoom);
       void visit(DoubleRoom doubleRoom);
   }
   ```

5. **HotelPricingVisitor.java**: A concrete visitor that calculates room prices.
   ```java
   public class HotelPricingVisitor implements HotelVisitor {
       @Override
       public void visit(SingleRoom singleRoom) {
           System.out.println("Single room price: 1000");
       }

       @Override
       public void visit(DoubleRoom doubleRoom) {
           System.out.println("Double room price: 3000");
       }
   }
   ```

6. **HotelBookingVisitor.java**: A concrete visitor that handles room bookings.
   ```java
   public class HotelBookingVisitor implements HotelVisitor {
       @Override
       public void visit(SingleRoom singleRoom) {
           System.out.println("Booking logic for single room");
       }
       
       @Override
       public void visit(DoubleRoom doubleRoom) {
           System.out.println("Booking logic for double room");
       }
   }
   ```

7. **UseVisitorPattern.java**: A client class that demonstrates how to use the Visitor pattern.
   ```java
   public class UseVisitorPattern {
       public static void useVisitorPattern() {
           HotelElement singleRoom = new SingleRoom();
           HotelElement doubleRoom = new DoubleRoom();

           HotelVisitor hotelVisitor = new HotelPricingVisitor();
           singleRoom.accept(hotelVisitor);
           doubleRoom.accept(hotelVisitor);

           HotelVisitor hotelBookingVisitor = new HotelBookingVisitor();
           doubleRoom.accept(hotelBookingVisitor);
       }
   }
   ```

## How It Works
1. The client creates concrete elements (SingleRoom and DoubleRoom).
2. The client creates concrete visitors (HotelPricingVisitor and HotelBookingVisitor).
3. The client calls the accept method on elements, passing a visitor as an argument.
4. Each element's accept method calls the visitor's visit method, passing itself as an argument.
5. The visitor performs the operation specific to the element type.

This double dispatch mechanism allows the visitor to perform different operations based on the element type without using conditional statements or type checking.

## Benefits of the Visitor Pattern
1. **Open/Closed Principle**: You can add new operations without modifying the element classes.
2. **Single Responsibility Principle**: Related behaviors are grouped in a visitor rather than spread across element classes.
3. **Accumulating State**: Visitors can maintain state as they visit elements in a complex structure.
4. **Separation of Concerns**: The pattern separates algorithms from the objects they operate on.
5. **Type Safety**: The pattern uses the type system to ensure that appropriate operations are performed on each element type.

## Drawbacks of the Visitor Pattern
1. **Breaking Encapsulation**: Visitors might need access to the internal details of elements.
2. **Rigid Element Hierarchy**: Adding or removing element types requires modifying all visitor interfaces and implementations.
3. **Complexity**: The pattern introduces additional classes and can make the code harder to understand.
4. **Dependency Cycle**: Elements and visitors depend on each other, creating a cyclic dependency.
5. **Performance**: The double dispatch mechanism can introduce overhead in performance-critical applications.

## Comparison with Other Patterns
- **Strategy**: Both patterns separate algorithms from the objects they operate on, but Strategy focuses on making algorithms interchangeable, while Visitor focuses on applying algorithms to different object types.
- **Command**: Command encapsulates a request as an object, while Visitor represents an operation to be performed on the elements of an object structure.
- **Iterator**: Both patterns traverse object structures, but Iterator focuses on providing sequential access, while Visitor focuses on performing operations.
- **Composite**: Visitor is often used with Composite to perform operations on complex object structures.

## Real-World Applications
- Document object model (DOM) traversal and manipulation
- Compiler design (abstract syntax tree traversal)
- Tax calculation systems (applying different tax rules to different types of items)
- Report generation (generating different reports from the same data structure)
- UI component frameworks (applying different operations to UI elements)
- Validation frameworks (applying different validation rules to different types of objects)
