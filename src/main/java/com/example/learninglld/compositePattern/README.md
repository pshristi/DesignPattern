# Composite Pattern

## Definition
The Composite Pattern is a structural design pattern that lets you compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

## When to Use
- When you want to represent part-whole hierarchies of objects
- When you want clients to be able to ignore the difference between compositions of objects and individual objects
- When the structure can have any level of complexity and is dynamic
- When you want the code to work with the common interface instead of concrete classes

## Components
1. **Component**: The common interface for all concrete classes in the composition
2. **Leaf**: Represents end objects of a composition with no children
3. **Composite**: Represents a component that may have children, stores child components and implements child-related operations
4. **Client**: Works with all elements through the component interface

## How It Works
1. The client interacts with the component interface
2. The component interface declares operations common to both simple and complex elements of the tree
3. Leaf elements implement the component interface directly
4. Composite elements implement the component interface and delegate work to their child components
5. The client can work with all elements without knowing their concrete classes

## Example Implementation in This Project

This package contains two examples of the Composite Pattern:

### Example 1: File System

#### Problem Statement
The problem statement directory shows a file system implementation without using the Composite Pattern:

```java
// File.java
public class File {
    String filename;
    
    File(String filename) {
        this.filename = filename;
    }
    
    public void ls() {
        System.out.println("File: " + filename);
    }
}

// Directory.java
public class Directory {
    String dirName;
    List<Object> filesAndDirectories;
    
    Directory(String dirName, List<Object> filesAndDirectories) {
        this.dirName = dirName;
        this.filesAndDirectories = filesAndDirectories;
    }
    
    public void ls() {
        System.out.println("Directory: " + dirName);
        for (Object item : filesAndDirectories) {
            if (item instanceof File) {
                ((File) item).ls();
            } else if (item instanceof Directory) {
                ((Directory) item).ls();
            }
        }
    }
}
```

This implementation has several issues:
- It uses a list of Object, which is not type-safe
- It uses instanceof checks to determine the type of each item
- File and Directory don't share a common interface

#### Solution with Composite Pattern

The designFilesystem directory shows a file system implementation using the Composite Pattern:

##### Component Interface (MyFileSystem.java)
```java
public interface MyFileSystem {
    void ls();
}
```

##### Leaf (File.java)
```java
public class File implements MyFileSystem {
    String filename;
    
    File(String filename) {
        this.filename = filename;
    }
    
    public void ls() {
        System.out.println("File: " + filename);
    }
}
```

##### Composite (Directory.java)
```java
public class Directory implements MyFileSystem {
    String dirName;
    List<MyFileSystem> filesAndDirectories;
    
    Directory(String dirName, List<MyFileSystem> filesAndDirectories) {
        this.dirName = dirName;
        this.filesAndDirectories = filesAndDirectories;
    }
    
    public void ls() {
        System.out.println("Directory: " + dirName);
        for (MyFileSystem item : filesAndDirectories) {
            item.ls();
        }
    }
}
```

##### Client Usage (fileSystemCorrectUsage.java)
```java
public class fileSystemCorrectUsage {
    public static void useFileSystem() {
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        List<MyFileSystem> list2 = new ArrayList<>();
        list2.add(file2);
        list2.add(file3);
        Directory dir2 = new Directory("dir2", list2);
        File file1 = new File("file1.txt");
        List<MyFileSystem> list1 = new ArrayList<>();
        list1.add(file1);
        list1.add(dir2);
        Directory dir1 = new Directory("dir1", list1);
        dir1.ls();
    }
}
```

### Example 2: Calculator

The designCalculator directory shows a calculator implementation using the Composite Pattern:

##### Component Interface (ArithmaticExpr.java)
```java
public interface ArithmaticExpr {
    int evaluate();
}
```

##### Leaf (NumberExpr.java)
```java
public class NumberExpr implements ArithmaticExpr {
    int number;
    
    public NumberExpr(int number) {
        this.number = number;
    }
    
    @Override
    public int evaluate() {
        return number;
    }
}
```

##### Operations Enum (MyCalculatorOperation.java)
```java
public enum MyCalculatorOperation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;
}
```

##### Composite (MyCalculatorExpression.java)
```java
public class MyCalculatorExpression implements ArithmaticExpr {
    ArithmaticExpr left;
    ArithmaticExpr right;
    MyCalculatorOperation operation;
    
    MyCalculatorExpression(MyCalculatorOperation operation, ArithmaticExpr left, ArithmaticExpr right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int evaluate() {
        switch (operation) {
            case ADD:
                return left.evaluate() + right.evaluate();
            case SUBTRACT:
                return left.evaluate() - right.evaluate();
            case MULTIPLY:
                return left.evaluate() * right.evaluate();
            case DIVIDE:
                return left.evaluate() / right.evaluate();
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}
```

##### Client Usage (MyCalculatorUsage.java)
```java
public class MyCalculatorUsage {
    public static void useCalculator() {
        //3*(4+9) = 3*13 = 39
        ArithmaticExpr number4 = new NumberExpr(4);
        ArithmaticExpr number9 = new NumberExpr(9);
        ArithmaticExpr add = new MyCalculatorExpression(ADD, number4, number9);
        ArithmaticExpr multiply = new MyCalculatorExpression(MULTIPLY, new NumberExpr(3), add);
        System.out.println("Results : " + multiply.evaluate());
    }
}
```

## Explanation of the Examples

### File System Example
In the file system example:
1. **Component**: `MyFileSystem` interface with the `ls()` method
2. **Leaf**: `File` class that implements `MyFileSystem`
3. **Composite**: `Directory` class that implements `MyFileSystem` and contains a list of `MyFileSystem` objects
4. **Client**: `fileSystemCorrectUsage` class that creates a file system structure and calls `ls()` on the root directory

The composite pattern allows for:
- Type-safe lists of files and directories (List<MyFileSystem>)
- No need for instanceof checks
- Uniform treatment of files and directories through the MyFileSystem interface

### Calculator Example
In the calculator example:
1. **Component**: `ArithmaticExpr` interface with the `evaluate()` method
2. **Leaf**: `NumberExpr` class that implements `ArithmaticExpr`
3. **Composite**: `MyCalculatorExpression` class that implements `ArithmaticExpr` and contains left and right `ArithmaticExpr` objects
4. **Client**: `MyCalculatorUsage` class that creates an expression tree and evaluates it

The composite pattern allows for:
- Building complex expressions by composing simpler expressions
- Uniform treatment of numbers and expressions through the ArithmaticExpr interface
- Recursive evaluation of expressions

## Benefits of the Composite Pattern
- **Simplifies Client Code**: Clients can treat individual objects and compositions uniformly
- **Makes Adding New Components Easy**: You can define new leaf or composite components without changing existing code
- **Represents Part-Whole Hierarchies**: Naturally represents recursive structures like trees
- **Follows Open/Closed Principle**: You can introduce new element types without breaking existing code

## Real-World Analogies
- File systems with files and directories
- Organization charts with employees and departments
- GUI components with simple elements and containers
- Mathematical expressions with numbers and operations
