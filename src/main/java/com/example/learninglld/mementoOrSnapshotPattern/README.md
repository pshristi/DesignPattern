# Memento Pattern (Snapshot Pattern)

## Overview
The Memento Pattern is a behavioral design pattern that allows you to capture and externalize an object's internal state without violating encapsulation, so that the object can be restored to this state later. It's also known as the Snapshot Pattern because it takes "snapshots" of an object's state.

## Key Concepts
- **Originator**: The object whose state needs to be saved and restored.
- **Memento**: An object that stores a snapshot of the originator's internal state.
- **Caretaker**: An object that keeps track of multiple mementos but never modifies the mementos it holds.

## When to Use
- When you need to create snapshots of an object's state to restore it later
- When direct access to an object's fields, getters, and setters would violate encapsulation
- When implementing undo/redo functionality
- When you need to implement checkpoints or save points in an application
- When you want to implement a versioning system

## Implementation in This Package

This package demonstrates the Memento pattern using a configuration example:

### Components
1. **ConfigurationOriginator.java**: The originator class whose state needs to be saved and restored.
   ```java
   public class ConfigurationOriginator {
       Integer height;
       Integer width;
       
       public ConfigurationOriginator(Integer height, Integer width) {
           this.height = height;
           this.width = width;
       }
       
       public ConfigurationMemento createMemento() {
           return new ConfigurationMemento(height, width);
       }
       
       public void restoreFromMemento(ConfigurationMemento memento) {
           this.height = memento.getHeight();
           this.width = memento.getWidth();
       }
       
       // Getters
       public Integer getHeight() { return height; }
       public Integer getWidth() { return width; }
   }
   ```

2. **ConfigurationMemento.java**: The memento class that stores the state of the originator.
   ```java
   public class ConfigurationMemento {
       Integer height;
       Integer width;
       
       public ConfigurationMemento(Integer height, Integer width) {
           this.height = height;
           this.width = width;
       }
       
       // Getters
       public Integer getHeight() { return height; }
       public Integer getWidth() { return width; }
   }
   ```

3. **ConfigurationCaretaker.java**: The caretaker class that manages mementos.
   ```java
   public class ConfigurationCaretaker {
       List<ConfigurationMemento> mementos = new ArrayList<>();
       
       public void addMemento(ConfigurationMemento memento) {
           this.mementos.add(memento);
       }
       
       public ConfigurationMemento undo() {
           if(mementos.size() > 0) {
               return mementos.remove(mementos.size() - 1);
           }
           return null;
       }
   }
   ```

4. **UseMemento.java**: A client class that demonstrates how to use the Memento pattern.
   ```java
   public static void useMemento() {
       ConfigurationOriginator originator = new ConfigurationOriginator(100, 200);
       ConfigurationCaretaker caretaker = new ConfigurationCaretaker();
       
       // Save the current state
       ConfigurationMemento snapshot1 = originator.createMemento();
       caretaker.addMemento(snapshot1);
       
       // Change the state
       originator.height = 50;
       originator.width = 150;
       
       ConfigurationMemento snapshot2 = originator.createMemento();
       caretaker.addMemento(snapshot2);
       
       // Change the state
       originator.height = 50;
       originator.width = 150;
       
       // Undo the changes
       ConfigurationMemento memento = caretaker.undo();
       originator.restoreFromMemento(memento);
       
       System.out.println("Originator State after undo: Height = " + originator.getHeight() + ", Width = " + originator.getWidth());
   }
   ```

## How It Works
1. The client creates an originator (ConfigurationOriginator) with an initial state.
2. The client creates a caretaker (ConfigurationCaretaker) to manage mementos.
3. When the client wants to save the originator's state, it calls the originator's createMemento() method to create a memento and adds it to the caretaker.
4. The client can change the originator's state as needed.
5. When the client wants to restore the originator to a previous state, it retrieves a memento from the caretaker and passes it to the originator's restoreFromMemento() method.
6. The originator uses the memento to restore its internal state.

## Benefits of the Memento Pattern
1. **Encapsulation**: The originator's internal state remains encapsulated, as the memento only exposes what the originator chooses to expose.
2. **Simplicity**: The pattern provides a clean way to implement undo/redo functionality.
3. **Single Responsibility Principle**: The pattern separates the responsibility of maintaining the originator's state history from the originator itself.
4. **Immutability**: Mementos are typically immutable, which makes them thread-safe and prevents unintended modifications.
5. **Flexibility**: The pattern allows for various implementations of state storage and retrieval strategies.

## Drawbacks of the Memento Pattern
1. **Memory Usage**: Storing many mementos can consume a lot of memory, especially if the originator's state is large.
2. **Performance**: Creating and restoring mementos can be expensive for objects with complex state.
3. **Garbage Collection**: If mementos hold references to objects that are no longer needed, it can prevent garbage collection.
4. **Complexity**: The pattern adds additional classes and complexity to the codebase.

## Comparison with Other Patterns
- **Command**: Both patterns can be used to implement undo functionality, but Command focuses on operations while Memento focuses on state.
- **Prototype**: Both patterns involve copying objects, but Prototype creates complete copies while Memento only copies the state.
- **State**: Both patterns deal with an object's state, but State focuses on changing behavior based on state while Memento focuses on saving and restoring state.
- **Serialization**: Serialization can be used to implement the Memento pattern, but it's typically more heavyweight and less flexible.

## Real-World Applications
- Text editors (undo/redo functionality)
- Graphics editors (history of changes)
- Game save systems
- Database transaction systems
- Version control systems
- Configuration management tools
