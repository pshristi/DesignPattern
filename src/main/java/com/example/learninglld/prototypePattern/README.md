# Prototype Pattern

## Overview
The Prototype Pattern is a creational design pattern that allows you to create new objects by copying an existing object, known as the prototype. This pattern is useful when the cost of creating a new object is more expensive than copying an existing one, or when you need to create objects with the same state as an existing object.

## Key Components
1. **Prototype**: An interface or abstract class that declares a method for cloning itself.
2. **ConcretePrototype**: A class that implements the Prototype interface and provides the implementation for cloning itself.
3. **Client**: The class that creates a new object by asking a prototype to clone itself.

## Implementation Details

### Without Prototype Pattern
The package includes an example of creating object copies without using the Prototype pattern:

#### Student Class
```java
public class Student {
    Integer id;
    String name;
    Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
        // default constructor
    }
}
```

#### Usage Without Prototype
```java
public class useStudent1 {
    public static void useStudent1() {
        Student student1 = new Student(1, "John", 20);
        Student student1clone = new Student();
        student1clone.setId(student1.getId());
        student1clone.setName(student1.getName());
        student1clone.setAge(student1.getAge()); //Issue arise when any property is private access
    }
}
```

In this approach, we manually copy each property from the original object to the new object. This becomes problematic when:
- The class has many properties
- Some properties have private access
- The class structure changes, requiring updates to all cloning code

### With Prototype Pattern
The package also includes an implementation using the Prototype pattern:

#### Prototype Interface
```java
public interface Prototype {
    Prototype clone();
}
```

#### StudentWithCloning Class
```java
public class StudentWithCloning implements Prototype {
    Integer id;
    String name;
    Integer age;

    public StudentWithCloning(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public Prototype clone() {
        return new StudentWithCloning(id, name, age);
    }
}
```

#### Usage With Prototype
```java
public class UsePrototypePattern {
    public static void usePrototypePattern() {
        StudentWithCloning student1 = new StudentWithCloning(1, "John Doe", 20);
        StudentWithCloning student1clone = (StudentWithCloning) student1.clone();
    }
}
```

With the Prototype pattern, cloning is simplified to a single method call. The cloning logic is encapsulated within the object itself, making it easier to create copies and avoiding issues with private properties.

## Benefits
1. **Reduced Subclassing**: You can clone objects without being dependent on their concrete classes.
2. **Reduced Initialization Cost**: Cloning can be more efficient than creating and initializing a new object from scratch.
3. **Simplified Object Creation**: Complex objects can be cloned with a single method call.
4. **Dynamic Configuration**: You can add or remove objects from the system by cloning existing ones.

## Use Cases
1. When a system should be independent of how its products are created, composed, and represented.
2. When the classes to instantiate are specified at run-time.
3. When avoiding the creation of a factory hierarchy is needed.
4. When instances of a class can have one of only a few different combinations of state.
