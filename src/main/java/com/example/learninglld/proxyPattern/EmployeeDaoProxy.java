package com.example.learninglld.proxyPattern;

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
