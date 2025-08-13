# Chain of Responsibility Pattern

## Definition
The Chain of Responsibility Pattern is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

## When to Use
- When more than one object may handle a request, and the handler isn't known a priori
- When you want to issue a request to one of several objects without specifying the receiver explicitly
- When the set of objects that can handle a request should be specified dynamically

## Components
1. **Handler Interface/Abstract Class**: Defines an interface for handling requests and optionally implements the successor link
2. **Concrete Handlers**: Handle requests they are responsible for; can access their successor
3. **Client**: Initiates the request to a handler in the chain

## How It Works
1. The client creates a chain of handler objects
2. The client passes a request to the first handler in the chain
3. Each handler decides whether to process the request or pass it to the next handler
4. The request travels along the chain until it's handled or reaches the end of the chain

## Example Implementation in This Project

### Handler Abstract Class (LogProcessor.java)
```java
public class LogProcessor {
    public static final Integer INFO = 1;
    public static final Integer DEBUG = 2;
    public static final Integer ERROR = 3;

    LogProcessor nextProcessor;
    LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void log(Integer logger, String message) {
        if(nextProcessor != null) {
            nextProcessor.log(logger, message);
        }
        else {
            System.out.println("No more processors available");
        }
    }
}
```

### Concrete Handler 1 (InfoLogProcessor.java)
```java
public class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Integer logger, String message) {
        if(logger == INFO) {
            System.out.println("INFO: " + message);
        }
        else {
           super.log(logger, message);
        }
    }
}
```

### Concrete Handler 2 (DebugLogProcessor.java)
```java
public class DebugLogProcessor extends LogProcessor {
    DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Integer logger, String message) {
        if(logger == DEBUG) {
            System.out.println("DEBUG: " + message);
        }
        else {
            super.log(logger, message);
        }
    }
}
```

### Concrete Handler 3 (ErrorLogProcessor.java)
```java
public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Integer logger, String message) {
        if(logger == ERROR) {
            System.out.println("ERROR: " + message);
        }
        else {
            super.log(logger, message);
        }
    }
}
```

### Client Usage (LoggerUsage.java)
```java
public class LoggerUsage {
    public static void useLogger() {
        LogProcessor infoProcessor = new InfoLogProcessor(new ErrorLogProcessor(null));
        infoProcessor.log(LogProcessor.INFO, "This is an info message");
        infoProcessor.log(LogProcessor.DEBUG, "This is a warning message");
        infoProcessor.log(LogProcessor.ERROR, "This is an error message");
    }
}
```

## Explanation of the Example
In this example:

1. **Handler Abstract Class**: `LogProcessor` defines the interface for handling log messages and maintains a reference to the next processor in the chain
2. **Concrete Handlers**: `InfoLogProcessor`, `DebugLogProcessor`, and `ErrorLogProcessor` each handle a specific log level and pass other log levels to the next processor
3. **Client**: `LoggerUsage` creates a chain of log processors and sends log messages of different levels to the chain

The chain is constructed as follows:
- `InfoLogProcessor` -> `ErrorLogProcessor` -> `null`

When a log message is sent to the chain:
- If it's an INFO level message, it's handled by `InfoLogProcessor`
- If it's an ERROR level message, it's passed to `ErrorLogProcessor` which handles it
- If it's a DEBUG level message, it's passed through the chain but not handled by any processor, resulting in "No more processors available" message

Note that in this example, the `DebugLogProcessor` is defined but not used in the chain, so DEBUG level logs are not handled.

## Benefits of the Chain of Responsibility Pattern
- **Decoupling**: The pattern decouples the sender of a request from its receivers
- **Flexibility**: You can add or remove handlers from the chain dynamically
- **Single Responsibility Principle**: Each handler is responsible for handling only one type of request
- **Open/Closed Principle**: You can add new handlers without changing existing code

## Real-World Analogies
- Customer service call routing through different departments
- Exception handling in programming languages
- Event bubbling in DOM (Document Object Model)
- Middleware in web frameworks
