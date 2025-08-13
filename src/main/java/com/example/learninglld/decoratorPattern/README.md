# Decorator Pattern

## Definition
The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. It is a flexible alternative to subclassing for extending functionality.

## When to Use
- When you need to add responsibilities to objects dynamically and transparently, without affecting other objects
- When extension by subclassing is impractical or impossible
- When you want to add functionality to individual objects without creating a large number of subclasses
- When you need to add and remove responsibilities at runtime

## Components
1. **Component**: The interface or abstract class defining the methods that will be implemented by concrete components and decorators
2. **Concrete Component**: The basic object that can be decorated with additional responsibilities
3. **Decorator**: The abstract class that implements the Component interface and has a reference to a Component object
4. **Concrete Decorator**: Adds responsibilities to the component

## How It Works
1. The client works with components through the Component interface
2. The Decorator wraps a Component and implements the same interface
3. The Decorator delegates operations to the wrapped Component and may perform additional operations before or after the delegation
4. Multiple decorators can be stacked to add multiple behaviors

## Example Implementation in This Project

### Component (BasePizza.java)
```java
public abstract class BasePizza {
    public abstract Integer cost();
}
```

### Concrete Components
#### Farmhouse.java
```java
public class Farmhouse extends BasePizza {
    @Override
    public Integer cost() {
        return 100;
    }
}
```

#### Vegdelight.java
```java
public class Vegdelight extends BasePizza  {
    @Override
    public Integer cost() {
        return 90;
    }
}
```

### Decorator (ToppingDecorator.java)
```java
public abstract class ToppingDecorator extends BasePizza  {
}
```

### Concrete Decorators
#### Extracheeze.java
```java
public class Extracheeze extends ToppingDecorator {
    BasePizza pizza;
    Extracheeze(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public Integer cost() {
        return pizza.cost() + 20;
    }
}
```

#### Extraveggies.java
```java
public class Extraveggies extends ToppingDecorator {
    BasePizza pizza;
    Extraveggies(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public Integer cost() {
        return pizza.cost() + 10;
    }
}
```

### Client Usage (placePizzaOrder.java)
```java
public class placePizzaOrder {
    public Integer getPizzaPrice() {
        BasePizza pizza = new Extracheeze(new Extraveggies(new Vegdelight()));
        return pizza.cost();
    }
}
```

## Explanation of the Example
In this example:

1. **Component**: `BasePizza` is the abstract class that defines the `cost()` method that all concrete components and decorators must implement
2. **Concrete Components**: `Farmhouse` and `Vegdelight` are concrete pizza types that extend `BasePizza` and provide their base costs
3. **Decorator**: `ToppingDecorator` is the abstract decorator class that extends `BasePizza`
4. **Concrete Decorators**: `Extracheeze` and `Extraveggies` are concrete decorators that extend `ToppingDecorator` and add additional cost to the wrapped pizza

The client code demonstrates how to use the decorator pattern to create a customized pizza:
1. It starts with a base `Vegdelight` pizza (cost: 90)
2. It wraps it with `Extraveggies` decorator (adds 10 to cost)
3. It wraps it again with `Extracheeze` decorator (adds 20 to cost)
4. The final cost is calculated by calling `cost()` on the outermost decorator, which recursively calls `cost()` on the inner components and adds its own cost

The total cost would be: 90 (Vegdelight) + 10 (Extraveggies) + 20 (Extracheeze) = 120

## Benefits of the Decorator Pattern
- **Open/Closed Principle**: You can extend an object's behavior without modifying existing code
- **Single Responsibility Principle**: You can divide a monolithic class that implements many possible variants of behavior into several smaller classes
- **Runtime Flexibility**: You can add or remove responsibilities from an object at runtime
- **Composability**: You can combine multiple decorators to create complex behaviors

## Real-World Analogies
- Adding toppings to a pizza (as in our example)
- Adding accessories to a car
- Wearing clothes (each piece of clothing "decorates" the person)
- Adding condiments to a coffee or sandwich
