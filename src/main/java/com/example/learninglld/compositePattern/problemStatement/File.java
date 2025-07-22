package com.example.learninglld.compositePattern.problemStatement;

public class File {
    String filename;

    File(String filename) {
        this.filename = filename;
    }

    public void ls() {
        System.out.println("File: " + filename);
    }
}
