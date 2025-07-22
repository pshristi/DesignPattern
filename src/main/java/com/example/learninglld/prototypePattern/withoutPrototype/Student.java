package com.example.learninglld.prototypePattern.withoutPrototype;

import lombok.Data;

@Data
public class Student {
    Integer id;
    String name;
    Integer age;

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
        // default constructor
    }
}
