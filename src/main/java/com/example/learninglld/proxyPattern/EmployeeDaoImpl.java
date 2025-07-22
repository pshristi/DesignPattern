package com.example.learninglld.proxyPattern;

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
