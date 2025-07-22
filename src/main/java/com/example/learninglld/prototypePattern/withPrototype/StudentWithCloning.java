package com.example.learninglld.prototypePattern.withPrototype;

public class StudentWithCloning implements Prototype {
    Integer id;
    String name;
    Integer age;

    public StudentWithCloning(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public Prototype clone() {
        return new StudentWithCloning(id, name, age);
    }
}
