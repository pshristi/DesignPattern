# Null Object Pattern

## Overview
The Null Object Pattern is a behavioral design pattern that uses a null object instead of a null reference. Instead of checking for null values, you can use a special "do-nothing" implementation of an interface or abstract class that provides default behavior.

## Key Concepts
- **Abstract Class/Interface**: Defines the interface for all objects, including the null object.
- **Real Object**: A concrete implementation of the abstract class/interface that provides the expected behavior.
- **Null Object**: A concrete implementation of the abstract class/interface that provides "do-nothing" or default behavior.
- **Client**: Uses objects of the abstract class/interface without checking for null.

## When to Use
- When you want to avoid null checks in client code
- When you want to provide default behavior for "not found" or "not applicable" cases
- When null values are expected in your application but should be handled gracefully
- When you want to simplify client code by removing conditional logic
- When you want to make your code more robust against NullPointerExceptions

## Implementation in This Package

This package demonstrates the Null Object pattern using a vehicle example:

### Components
1. **Vehicle.java**: An interface defining the contract for all vehicles.
   ```java
   public interface Vehicle {
       Integer getSeatingCapacity();
   }
   ```

2. **Car.java**: A concrete implementation of the Vehicle interface (a real object).
   ```java
   public class Car implements Vehicle {
       @Override
       public Integer getSeatingCapacity() {
           return 5;
       }
   }
   ```

3. **NullVehicle.java**: A null object implementation of the Vehicle interface.
   ```java
   public class NullVehicle implements Vehicle {
       @Override
       public Integer getSeatingCapacity() {
           return 0;
       }
   }
   ```

4. **VehicleFactory.java**: A factory class that creates vehicles, returning a NullVehicle when the requested vehicle type is not available.
   ```java
   public class VehicleFactory {
       public Vehicle createVehicle(String vehicleType) {
           switch (vehicleType) {
               case "Car" :
                   return new Car();
               default:
                   return new NullVehicle();
           }
       }
   }
   ```

5. **nullPatternUsage.java**: A client class that demonstrates how to use the Null Object pattern.
   ```java
   public void useNullPattern() {
       VehicleFactory vehicleFactory = new VehicleFactory();
       Vehicle vehicle1 = vehicleFactory.createVehicle("Car");
       System.out.println("Seating capacity: " + vehicle1.getSeatingCapacity());

       Vehicle vehicle2 = vehicleFactory.createVehicle("Bike");
       System.out.println("Seating capacity: " + vehicle2.getSeatingCapacity());
   }
   ```

## How It Works
1. The client requests a vehicle from the VehicleFactory.
2. If the requested vehicle type is "Car", the factory returns a Car object.
3. If the requested vehicle type is anything else, the factory returns a NullVehicle object instead of null.
4. The client can call methods on the returned object without checking for null, even when the requested vehicle type doesn't exist.
5. The NullVehicle provides default behavior (returning 0 for seating capacity) that prevents NullPointerExceptions.

## Benefits of the Null Object Pattern
1. **Eliminates Null Checks**: Client code doesn't need to check for null before calling methods.
2. **Prevents NullPointerExceptions**: The null object provides safe default behavior.
3. **Simplifies Client Code**: Reduces conditional logic in client code.
4. **Improves Readability**: Makes the code more readable by removing null-checking boilerplate.
5. **Follows the Special Case Pattern**: Treats the null case as a special case with its own behavior.

## Drawbacks of the Null Object Pattern
1. **Hidden Errors**: May hide errors that would otherwise be caught by null checks.
2. **Increased Complexity**: Adds additional classes to the codebase.
3. **Default Behavior May Not Be Appropriate**: The default behavior provided by the null object may not be suitable for all cases.
4. **Difficult to Test for Absence**: It can be harder to test whether a "real" object or a null object was returned.

## Comparison with Other Patterns
- **Special Case Pattern**: The Null Object pattern is a specific case of the Special Case pattern, which provides special handling for edge cases.
- **Strategy Pattern**: Both patterns involve different implementations of an interface, but the Null Object pattern specifically addresses the null case.
- **Factory Method**: Often used together with the Null Object pattern to create and return null objects when appropriate.
- **State Pattern**: Similar in that both patterns use different implementations of an interface, but the State pattern focuses on changing behavior based on state.

## Real-World Applications
- Default user profiles when a user is not logged in
- Empty collections instead of null collections
- Default configurations when a configuration is not found
- Placeholder images when an image is not available
- Default handlers for events when no specific handler is registered
