package com.example.learninglld.builderPattern;

public class StudentBuilder {
    Integer id;
    String name;
    String fatherName;
    String motherName;
    Integer age;
    public StudentBuilder setId(Integer id) {
        this.id = id;
        return this;
    }
    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }
    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }
    public StudentBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }
    public Student build() {
        return new Student(this);
    }
}
