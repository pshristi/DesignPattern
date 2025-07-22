package com.example.learninglld.liskov_substitution;

public class Bicycle implements Vehicle{
    @Override
    public Integer getWheels() {
        return 2;
    }

    @Override
    public Boolean hasEngine() {
        return null;
    }
}
