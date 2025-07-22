package com.example.learninglld.mementoOrSnapshotPattern;

public class ConfigurationMemento {
    Integer height;
    Integer width;

    public ConfigurationMemento(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}
