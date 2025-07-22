package com.example.learninglld.proxyPattern;

public interface EmployeeDao {
    void saveEmployee(Employee employee, String user);

    Employee getEmployeeById(Integer id, String user);
}
