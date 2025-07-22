package com.example.learninglld.liskov_substitution;

public class Car implements Vehicle {

    @Override
    public Integer getWheels() {
        return 4;
    }

    @Override
    public Boolean hasEngine() {
        return true;
    }
}
