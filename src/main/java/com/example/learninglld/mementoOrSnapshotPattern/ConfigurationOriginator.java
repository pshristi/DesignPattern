package com.example.learninglld.mementoOrSnapshotPattern;


public class ConfigurationOriginator {
    Integer height;
    Integer width;

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public ConfigurationOriginator(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    public ConfigurationMemento createMemento() {
        return new ConfigurationMemento(height, width);
    }

    public void restoreFromMemento(ConfigurationMemento memento) {
        this.height = memento.getHeight();
        this.width = memento.getWidth();
    }

}
