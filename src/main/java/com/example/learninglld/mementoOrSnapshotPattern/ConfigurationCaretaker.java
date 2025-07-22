package com.example.learninglld.mementoOrSnapshotPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCaretaker {

    List<ConfigurationMemento> mementos = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento) {
        this.mementos.add(memento);
    }

    public ConfigurationMemento undo() {
        if(mementos.size() > 0) {
            return mementos.remove(mementos.size() - 1);
        }
        return null;
    }
}
