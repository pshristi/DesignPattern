# Command Pattern

## Definition
The Command Pattern is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

## When to Use
- When you want to parameterize objects with operations
- When you want to queue operations, schedule their execution, or execute them remotely
- When you want to implement reversible operations (undo/redo functionality)
- When you want to structure a system around high-level operations built on primitive operations

## Components
1. **Command Interface**: Declares a method for executing a command
2. **Concrete Command**: Implements the Command interface and defines the binding between a receiver object and an action
3. **Invoker**: Asks the command to carry out the request
4. **Receiver**: Knows how to perform the operations associated with carrying out a request
5. **Client**: Creates a ConcreteCommand object and sets its receiver

## How It Works
1. The client creates a command object and specifies its receiver
2. An invoker object stores the command object
3. The invoker calls the command's execute method, which invokes operations on the receiver
4. For undoable commands, the command stores state for undoing the command before executing it

## Example Implementation in This Project

### Receiver (AC.java)
```java
public class AC {
    private boolean isOn;
    private int currentTemperature;

    public AC() {
        isOn = false;
        currentTemperature = 20;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("AC is on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("AC is off");
    }

    public void setTemperature(int temperature) {
        currentTemperature = temperature;
        System.out.println("AC temperature is set to " + currentTemperature);
    }
}
```

### Command Interface (ICommand.java)
```java
public interface ICommand {
    void execute();
    void undo();
}
```

### Concrete Command 1 (TurnOnAcCommand.java)
```java
public class TurnOnAcCommand implements ICommand {
    AC ac;

    public TurnOnAcCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOn();
    }

    @Override
    public void undo() {
        ac.turnOff();
    }
}
```

### Concrete Command 2 (TurnOffAcCommand.java)
```java
public class TurnOffAcCommand implements ICommand {
    AC ac;

    public TurnOffAcCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOff();
    }

    @Override
    public void undo() {
        ac.turnOn();
    }
}
```

### Invoker (MyRemoteControl.java)
```java
public class MyRemoteControl {
    Stack<ICommand> commmandHistory = new Stack<>();
    ICommand currentCommand;

    public void setCommand(ICommand command) {
        currentCommand = command;
    }

    public void pressButton() {
        currentCommand.execute();
        commmandHistory.add(currentCommand);
    }

    public void pressUndo() {
        if (!commmandHistory.isEmpty()) {
            ICommand undoCommand = commmandHistory.pop();
            undoCommand.undo();
        }
    }
}
```

### Client Usage (UseAc.java)
```java
public class UseAc {
    public void useAC() {
        AC ac = new AC();
        ac.turnOn();
        ac.setTemperature(22);
        ac.turnOff();
    }

    public static void useAc1() {
       AC ac = new AC();
       MyRemoteControl remoteControl = new MyRemoteControl();

       remoteControl.setCommand(new TurnOnAcCommand(ac));
       remoteControl.pressButton();
       remoteControl.pressUndo();
    }
}
```

## Explanation of the Example
In this example:

1. **Receiver**: `AC` class that knows how to perform the operations (turn on, turn off, set temperature)
2. **Command Interface**: `ICommand` interface with `execute()` and `undo()` methods
3. **Concrete Commands**: `TurnOnAcCommand` and `TurnOffAcCommand` that implement the `ICommand` interface and encapsulate operations on the AC
4. **Invoker**: `MyRemoteControl` that holds a command and triggers its execution
5. **Client**: `UseAc` class that creates the receiver, commands, and invoker, and demonstrates their usage

The example demonstrates two approaches:
- **Without Command Pattern** (`useAC()` method): The client directly calls methods on the AC object
- **With Command Pattern** (`useAc1()` method): The client creates a command object, sets it on the remote control, and the remote control executes the command

The command pattern implementation also supports undo functionality:
1. When a command is executed, it's added to a history stack
2. When undo is requested, the last command is popped from the stack and its `undo()` method is called

## Benefits of the Command Pattern
- **Decoupling**: Decouples the object that invokes the operation from the one that knows how to perform it
- **Extensibility**: New commands can be added without changing existing code
- **Composite Commands**: Commands can be composed to create macro commands
- **Undo/Redo**: Supports undoable operations by implementing the `undo()` method
- **Queueing and Logging**: Commands can be queued, logged, and scheduled for execution

## Real-World Analogies
- Remote controls where buttons are mapped to different commands
- Menu items in a GUI application
- Transactions in a database system
- Macro recorders in applications
