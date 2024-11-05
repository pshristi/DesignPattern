package com.example.learninglld.facadePattern;

import com.example.learninglld.proxyPattern.Employee;

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
