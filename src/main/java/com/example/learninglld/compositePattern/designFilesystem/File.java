package com.example.learninglld.compositePattern.designFilesystem;

public class File implements MyFileSystem {
    String filename;

    File(String filename) {
        this.filename = filename;
    }

    public void ls() {
        System.out.println("File: " + filename);
    }
}
