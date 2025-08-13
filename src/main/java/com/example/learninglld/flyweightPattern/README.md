# Flyweight Pattern

## Overview
The Flyweight Pattern is a structural design pattern that aims to minimize memory usage by sharing as much data as possible with similar objects. It is particularly useful when you need to create a large number of similar objects that differ only in a few parameters.

## Key Concepts
- **Intrinsic State**: The shared part of an object's state that can be stored externally and passed to the object when needed.
- **Extrinsic State**: The variable part of an object's state that cannot be shared and must be passed to the object when a method is called.
- **Flyweight Factory**: A factory that creates and manages flyweight objects. It ensures that flyweights are shared properly.

## When to Use
- When an application needs to create a large number of similar objects
- When memory usage is a concern
- When most of an object's state can be made extrinsic
- When the application doesn't depend on object identity

## Implementation in This Package

This package contains three examples of the Flyweight pattern:

### 1. Robot Example (with vs. without Flyweight)

#### Without Flyweight (`withoutFlyweight` package)
In the non-flyweight implementation, each robot is a separate object with its own state:
- `Robot.java`: A class representing a robot with its own type, coordinates (x, y), and sprite.
- `Sprites.java`: A class representing the graphical data for a robot (simulated as a 2D bitmap).

When creating many robots (as shown in `testFlyweightPattern.java`), each robot has its own sprite object, which consumes a lot of memory.

#### With Flyweight (`withFlyweight` package)
In the flyweight implementation:
- `IRobot.java`: An interface defining the display method that takes extrinsic state (coordinates).
- `HumanoidRobot.java` and `RoboticDog.java`: Concrete flyweight implementations that store intrinsic state (type and sprite).
- `RoboticFactory.java`: A factory that creates and manages robot instances, ensuring that only one instance of each robot type exists.

The key difference is that the flyweight implementation separates intrinsic state (type, sprite) from extrinsic state (coordinates). The intrinsic state is stored in the flyweight object, while the extrinsic state is passed to the display method. This allows many robots of the same type to share a single flyweight object, significantly reducing memory usage.

### 2. Word Processor Example (`wordProcessor` package)

This example demonstrates how the Flyweight pattern can be used in a word processor to efficiently represent text:
- `ICharacter.java`: An interface defining the display method for characters.
- `Letter.java`: A concrete flyweight implementation that stores intrinsic state (character, font type, font size).
- `LetterFactory.java`: A factory that creates and manages letter instances, ensuring that only one instance of each character exists.
- `UseWordProcessor.java`: A class demonstrating how to use the word processor with the Flyweight pattern.

In a typical document, many characters are repeated (e.g., 'e', 't', 'a'). Using the Flyweight pattern, only one instance of each character is created, regardless of how many times it appears in the document. This saves memory, especially for large documents.

## Benefits of the Flyweight Pattern
1. **Memory Efficiency**: Reduces the number of objects created, saving memory.
2. **Performance**: Can improve performance by reducing the amount of memory access.
3. **Scalability**: Allows applications to handle a larger number of objects with the same amount of memory.

## Drawbacks of the Flyweight Pattern
1. **Complexity**: Adds complexity to the code by separating intrinsic and extrinsic state.
2. **Runtime Cost**: May introduce runtime overhead due to the need to compute or pass extrinsic state.
3. **Thread Safety**: Care must be taken to ensure thread safety when sharing flyweight objects.

## Comparison with Other Patterns
- **Singleton**: Both ensure that only one instance of a particular type exists, but for different reasons. Singleton ensures uniqueness, while Flyweight ensures memory efficiency.
- **Object Pool**: Both reuse objects, but Object Pool reuses objects temporarily, while Flyweight shares objects permanently.
- **Composite**: Flyweight can be used with Composite to share leaf nodes.

## Real-World Applications
- Text editors and word processors (as shown in the wordProcessor example)
- Graphics rendering systems (as shown in the robot example)
- Game development (for sharing game objects with similar properties)
- Network connection pools
- String interning in programming languages
