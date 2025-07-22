package com.example.learninglld.strategyOrBridgePattern.withStrategyPattern;

import com.example.learninglld.strategyOrBridgePattern.withStrategyPattern.strategy.DrivingStrategy;

public class Vehicle {
    DrivingStrategy drivingStrategy;

    public Vehicle(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive() {
        drivingStrategy.drive();
    }
}
