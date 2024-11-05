package com.example.learninglld.prototypePattern.withoutPrototype;

public class useStudent1 {
    public static void useStudent1() {
        Student student1 = new Student(1, "John", 20);
        Student student1clone = new Student();
        student1clone.setId(student1.getId());
        student1clone.setName(student1.getName());
        student1clone.setAge(student1.getAge());//Issue arise when any property is private access
    }
}
