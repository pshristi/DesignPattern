package com.example.learninglld.compositePattern.designFilesystem;

import com.example.learninglld.designHashMap.MyHashMap;

import java.util.List;

public class Directory implements MyFileSystem {
    String dirName;
    List<MyFileSystem> filesAndDirectories;

    Directory(String dirName, List<MyFileSystem> filesAndDirectories) {
        this.dirName = dirName;
        this.filesAndDirectories = filesAndDirectories;
    }

    public void ls() {
        System.out.println("Directory: " + dirName);
        for (MyFileSystem item : filesAndDirectories) {
            item.ls();
        }
    }
}
