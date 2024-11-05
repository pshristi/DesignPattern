package com.example.learninglld.prototypePattern.withPrototype;

public class UsePrototypePattern {
    public static void usePrototypePattern() {
        StudentWithCloning student1 = new StudentWithCloning(1, "John Doe", 20);
        StudentWithCloning student1clone = (StudentWithCloning) student1.clone();
    }
}
