package com.example.learninglld.builderPattern;

public class Student {
    Integer id;
    String name;
    String fatherName;
    String motherName;
    Integer age;
    public Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.age = studentBuilder.age;
    }
}
