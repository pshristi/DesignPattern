package com.example.learninglld.facadePattern;

import com.example.learninglld.proxyPattern.Employee;

import java.util.UUID;

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
