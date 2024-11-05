package com.example.learninglld.builderPattern;

public class StudentBuilderUsage {
    public static void useBuilder() {
        Student student = new StudentBuilder()
                .setName("John Doe")
                .setAge(25)
                .build();

        System.out.println(student);
    }
}
