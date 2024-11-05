package com.example.learninglld.compositePattern.problemStatement;

import java.util.List;

public class Directory {
    String dirName;
    List<Object> filesAndDirectories;

    Directory(String dirName, List<Object> filesAndDirectories) {
        this.dirName = dirName;
        this.filesAndDirectories = filesAndDirectories;
    }

    public void ls() {
        System.out.println("Directory: " + dirName);
        for (Object item : filesAndDirectories) {
            if (item instanceof File) {
                ((File) item).ls();
            } else if (item instanceof Directory) {
                ((Directory) item).ls();
            }
        }
    }
}
