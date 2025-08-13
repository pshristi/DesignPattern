# Factory Pattern

## Definition
The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. It defines a method for creating objects without specifying the exact class of object that will be created.

## When to Use
- When a class cannot anticipate the type of objects it must create
- When a class wants its subclasses to specify the objects it creates
- When you want to encapsulate object creation logic in a separate class
- When you want to decouple the client code from the concrete classes it uses

## Components
1. **Product**: The interface or abstract class defining the objects the factory method creates
2. **Concrete Products**: Classes that implement the Product interface
3. **Creator**: The class that declares the factory method
4. **Concrete Creator**: Subclasses that override the factory method to return specific Concrete Products

## How It Works
1. The client calls the factory method with parameters indicating the type of object needed
2. The factory method creates and returns the appropriate object based on the parameters
3. The client uses the object through its interface, without knowing its concrete class

## Example Implementation in This Project

### Product Interface (Shape.java)
```java
public interface Shape {
    public void draw();
}
```

### Concrete Products
#### Circle.java
```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
```

#### Rectangle.java
```java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
```

### Creator (ShapeFactory.java)
```java
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}
```

### Client Usage (UsePattern.java)
```java
public class UsePattern {
    public void drawShape() {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();
    }
}
```

## Explanation of the Example
In this example:

1. **Product Interface**: `Shape` defines the common interface for all shapes with a `draw()` method
2. **Concrete Products**: `Circle` and `Rectangle` implement the `Shape` interface, providing their own implementations of the `draw()` method
3. **Creator**: `ShapeFactory` provides a factory method `getShape(String shapeType)` that creates and returns different types of shapes based on the input parameter
4. **Client**: `UsePattern` demonstrates how to use the factory to create different shapes without knowing their concrete classes

The client code creates a `ShapeFactory` and uses it to create a circle and a rectangle. It then calls the `draw()` method on each shape. The client code only interacts with the `Shape` interface and the `ShapeFactory`, without knowing the concrete classes `Circle` and `Rectangle`.

This implementation demonstrates the Simple Factory variant of the Factory Pattern. In a true Factory Method pattern, the factory method would be defined in an abstract class and overridden by subclasses to create different types of products.

## Benefits of the Factory Pattern
- **Encapsulation**: Encapsulates the object creation logic in a separate class
- **Decoupling**: Decouples the client code from the concrete classes it uses
- **Centralization**: Centralizes object creation logic, making it easier to change
- **Open/Closed Principle**: You can add new product types without modifying existing code
- **Single Responsibility Principle**: Separates the responsibility of creating objects from using them

## Real-World Analogies
- A restaurant where the waiter (client) orders food from the kitchen (factory) without knowing how the food is prepared
- A car factory that produces different models of cars using the same assembly line
- A document generator that creates different types of documents (PDF, Word, etc.) based on user input
