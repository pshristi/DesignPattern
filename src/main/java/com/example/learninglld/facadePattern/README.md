# Facade Pattern

## Definition
The Facade Pattern is a structural design pattern that provides a simplified interface to a complex subsystem of classes, making it easier to use. It defines a higher-level interface that makes the subsystem easier to use by reducing complexity and hiding the implementation details.

## When to Use
- When you want to provide a simple interface to a complex subsystem
- When there are many dependencies between clients and the implementation classes of an abstraction
- When you want to layer your subsystems and use a facade as an entry point to each subsystem level
- When you want to decouple your client implementation from the complex subsystem

## Components
1. **Facade**: Provides a simplified interface to the subsystem
2. **Subsystem Classes**: Implement the functionality of the subsystem
3. **Client**: Uses the facade to interact with the subsystem

## How It Works
1. The client interacts with the facade instead of directly with the subsystem
2. The facade delegates client requests to appropriate subsystem objects
3. The subsystem objects perform the actual work, but they are not aware of the facade
4. The client is shielded from the complexity of the subsystem

## Example Implementation in This Project

### Subsystem Class (EmployeeDao.java)
```java
public class EmployeeDao {
    public void insert(Employee employee) {
        // Implementation to save employee to database
        System.out.println("Inserted employee: " + employee.getName());
    }

    public void update(Employee employee) {
        System.out.println("Updated employee: " + employee.getName());
    }

    public Employee getById(Integer id) {
        // Implementation to fetch employee from database
        return new Employee("John Doe", id);
    }

    public void delete(Employee employee) {
        System.out.println("Deleted employee: " + employee.getName());
    }

    public Employee getEmplyeeByName(String name) {
        // Implementation to fetch employee from database by name
        System.out.println("Get employee by name: " + name);
        return new Employee("John Doe", 1);
    }
}
```

### Facade (EmployeeFacade.java)
```java
public class EmployeeFacade {
    private EmployeeDao employeeDao;
    public EmployeeFacade() {
        this.employeeDao = new EmployeeDao();
    }
    public void createNewEmployeeAndReturnEmployee(String name) {
        Integer generatedId = Integer.parseInt(UUID.randomUUID().toString().substring(0, 8));
        Employee employee = new Employee(name, generatedId);
        employeeDao.insert(employee);
        System.out.println("Employee created: " + employee);
        employeeDao.getById(generatedId);
    }
}
```

### Client Usage (facadeUsage.java)
```java
public class facadeUsage {
    public void useFacade() {
        EmployeeFacade facade = new EmployeeFacade();
        facade.createNewEmployeeAndReturnEmployee("John Doe");
    }
}
```

## Explanation of the Example
In this example:

1. **Subsystem**: `EmployeeDao` is a complex subsystem that provides various methods for employee data access, including insert, update, getById, delete, and getEmplyeeByName.

2. **Facade**: `EmployeeFacade` provides a simplified interface to the subsystem. It encapsulates the complexity of:
   - Generating a unique ID for a new employee
   - Creating an Employee object
   - Inserting the employee into the database
   - Retrieving the employee by ID

3. **Client**: `facadeUsage` demonstrates how to use the facade. The client only needs to:
   - Create an instance of the facade
   - Call a single method with the employee name

Without the facade, the client would need to:
1. Generate a unique ID
2. Create an Employee object
3. Call the insert method on EmployeeDao
4. Call the getById method on EmployeeDao

The facade simplifies this process by providing a single method that handles all these steps, making the client code cleaner and more maintainable.

## Benefits of the Facade Pattern
- **Simplifies Client Interface**: Clients interact with a single, simplified interface rather than multiple complex subsystems
- **Decoupling**: Reduces dependencies between client code and subsystem implementation
- **Layering**: Helps organize code into layers, with facades serving as entry points to each layer
- **Encapsulation**: Hides the complexities of the subsystem from clients
- **Testability**: Makes it easier to test client code by mocking the facade instead of multiple subsystem classes

## Real-World Analogies
- A car's dashboard, which provides a simplified interface to the complex systems of the car
- A restaurant waiter who acts as a facade between customers and the kitchen staff
- A computer's operating system, which provides a simplified interface to the hardware
- A remote control that simplifies the operation of multiple electronic devices
