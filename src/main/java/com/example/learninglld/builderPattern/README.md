# Builder Pattern

## Definition
The Builder Pattern is a creational design pattern that separates the construction of a complex object from its representation, allowing the same construction process to create different representations. It provides a step-by-step approach to building a complex object, with the ability to use only the steps needed.

## When to Use
- When you need to create complex objects with many optional parameters
- When you want to avoid telescoping constructors (multiple constructors with different parameter combinations)
- When you want to create different representations of an object using the same construction process
- When you need to ensure that an object is fully constructed before it's used

## Components
1. **Product**: The complex object being built
2. **Builder**: An interface that defines the steps to build the product
3. **Concrete Builder**: Implements the Builder interface and provides specific implementations for the building steps
4. **Director** (optional): Controls the building process using the builder

## How It Works
1. The client creates a builder instance
2. The client calls setter methods on the builder to configure the product's attributes
3. The client calls the build() method to get the final product
4. The builder constructs and returns the product

## Example Implementation in This Project

### Product (Student.java)
```java
public class Student {
    Integer id;
    String name;
    String fatherName;
    String motherName;
    Integer age;
    public Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.age = studentBuilder.age;
    }
}
```

### Builder (StudentBuilder.java)
```java
public class StudentBuilder {
    Integer id;
    String name;
    String fatherName;
    String motherName;
    Integer age;
    public StudentBuilder setId(Integer id) {
        this.id = id;
        return this;
    }
    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }
    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }
    public StudentBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }
    public Student build() {
        return new Student(this);
    }
}
```

### Client Usage (StudentBuilderUsage.java)
```java
public class StudentBuilderUsage {
    public static void useBuilder() {
        Student student = new StudentBuilder()
                .setName("John Doe")
                .setAge(25)
                .build();

        System.out.println(student);
    }
}
```

## Explanation of the Example
In this example:

1. **Product**: `Student` class with multiple attributes (id, name, fatherName, motherName, age)
2. **Builder**: `StudentBuilder` class with methods to set each attribute and a build() method

The implementation demonstrates:

1. The `StudentBuilder` has the same attributes as the `Student` class
2. Each setter method in `StudentBuilder` returns the builder instance itself, allowing for method chaining
3. The `build()` method creates and returns a new `Student` object by passing the builder instance to the `Student` constructor
4. The client code in `StudentBuilderUsage` shows how to create a `Student` object by chaining method calls on the builder

Note that in this example, the client only sets the name and age attributes, demonstrating how the Builder pattern allows for creating objects with only a subset of attributes set.

## Benefits of the Builder Pattern
- **Flexibility**: Allows creating different representations of an object using the same construction process
- **Readability**: Makes the code more readable by clearly showing which parameters are being set
- **Immutability**: Can be used to create immutable objects without complex constructors
- **Step-by-step Construction**: Allows for step-by-step construction of complex objects
- **Parameter Validation**: Can validate parameters before constructing the object

## Real-World Analogies
- A car manufacturing process where different components are assembled step by step
- A meal at a restaurant where you can customize various aspects (ingredients, cooking style, etc.)
- A document builder that allows you to add different sections and formatting options
