package com.example.learninglld.proxyPattern;

import lombok.Data;

@Data
public class Employee {
    String name;
    Integer id;

    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}
