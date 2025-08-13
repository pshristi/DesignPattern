# Proxy Pattern

## Overview
The Proxy Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It creates a representative object that controls access to another object, which may be remote, expensive to create, or in need of securing.

## Key Concepts
- **Subject**: An interface that defines the common operations for both the RealSubject and the Proxy.
- **RealSubject**: The real object that the proxy represents.
- **Proxy**: Maintains a reference to the RealSubject and controls access to it.

## Types of Proxy Patterns
1. **Virtual Proxy**: Delays the creation and initialization of expensive objects until needed.
2. **Protection Proxy**: Controls access to the original object based on access rights.
3. **Remote Proxy**: Represents an object that is in a different address space.
4. **Smart Proxy**: Performs additional actions when an object is accessed.

## When to Use
- When you need to control access to an object
- When you want to add functionality when accessing an object
- When the original object is in a different address space
- When you want to delay the creation of expensive objects until needed

## Implementation in This Package

This package demonstrates the Protection Proxy pattern using an employee management system:

### Components

1. **Employee.java**: A simple data class representing an employee.
   ```java
   @Data
   public class Employee {
       String name;
       Integer id;

       public Employee(String name, Integer id) {
           this.name = name;
           this.id = id;
       }
   }
   ```

2. **EmployeeDao.java**: An interface defining operations that can be performed on Employee objects.
   ```java
   public interface EmployeeDao {
       void saveEmployee(Employee employee, String user);
       Employee getEmployeeById(Integer id, String user);
   }
   ```

3. **EmployeeDaoImpl.java**: The real implementation of the EmployeeDao interface.
   ```java
   public class EmployeeDaoImpl implements EmployeeDao {
       public void saveEmployee(Employee employee, String user) {
           System.out.println("Saving employee: " + employee.getName());
       }

       public Employee getEmployeeById(Integer id, String user) {
           System.out.println("Getting employee by id: " + id);
           // Implementation to fetch employee from database
           return new Employee("John Doe", id);
       }
   }
   ```

4. **EmployeeDaoProxy.java**: A proxy that controls access to the EmployeeDaoImpl based on user permissions.
   ```java
   public class EmployeeDaoProxy implements EmployeeDao {
       private EmployeeDao employeeDao;
       
       EmployeeDaoProxy(EmployeeDao employeeDao) {
           this.employeeDao = employeeDao;
       }
       
       public void saveEmployee(Employee employee, String user) {
           if("ADMIN".equals(user)) {
               employeeDao.saveEmployee(employee, user);
           }
           else {
               System.out.println("Access denied");
           }
       }

       public Employee getEmployeeById(Integer id, String user) {
           if("ADMIN".equals(user)) {
               return employeeDao.getEmployeeById(id, user);
           }
           else {
               System.out.println("Access denied");
               return null;
           }
       }
   }
   ```

## How It Works
1. The client interacts with the EmployeeDao interface.
2. The EmployeeDaoProxy implements this interface and holds a reference to the real EmployeeDaoImpl.
3. When a client calls methods on the proxy, it first checks if the user has the necessary permissions (in this case, if the user is an "ADMIN").
4. If the user has permissions, the proxy delegates the call to the real implementation.
5. If the user doesn't have permissions, the proxy denies access and returns an appropriate response.

## Benefits of the Proxy Pattern
1. **Access Control**: The proxy can control access to the real object based on permissions.
2. **Lazy Initialization**: The proxy can delay the creation of expensive objects until they are actually needed.
3. **Logging and Monitoring**: The proxy can log method calls, parameters, etc. before delegating to the real object.
4. **Caching**: The proxy can cache results to improve performance.
5. **Remote Access**: The proxy can handle the complexity of accessing remote objects.

## Drawbacks of the Proxy Pattern
1. **Complexity**: Adds an additional layer of indirection, which can make the code more complex.
2. **Performance**: May introduce a slight performance overhead due to the additional indirection.

## Comparison with Other Patterns
- **Decorator**: Both patterns intercept calls to an object, but decorators add behavior to the object, while proxies control access to it.
- **Adapter**: Adapters provide a different interface to an object, while proxies provide the same interface but control access to it.
- **Facade**: Facades simplify a complex subsystem, while proxies control access to an object.

## Real-World Applications
- Access control systems
- Caching systems
- Lazy loading of resources
- Remote method invocation (RMI)
- Object-relational mapping (ORM) frameworks
