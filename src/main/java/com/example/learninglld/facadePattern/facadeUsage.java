package com.example.learninglld.facadePattern;

public class facadeUsage {
    public void useFacade() {
        EmployeeFacade facade = new EmployeeFacade();
        facade.createNewEmployeeAndReturnEmployee("John Doe");
    }
}
