package com.example.learninglld.compositePattern.problemStatement;

import java.util.ArrayList;
import java.util.List;

public class fileSystemUsage {
    public static void useFileSystem() {
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        List<Object> list2 = new ArrayList<>();
        list2.add(file2);
        list2.add(file3);
        Directory dir2 = new Directory("dir2", list2);
        File file1 = new File("file1.txt");
        List<Object> list1 = new ArrayList<>();
        list1.add(file1);
        list1.add(dir2);
        Directory dir1 = new Directory("dir1", list1);
        dir1.ls();
    }
}
