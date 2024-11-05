package com.example.learninglld.strategyOrBridgePattern.withStrategyPattern;

import com.example.learninglld.strategyOrBridgePattern.withStrategyPattern.strategy.SimpleDrivingStrategy;

public class PassengerVehicle extends Vehicle {
    PassengerVehicle() {
        super(new SimpleDrivingStrategy());
    }
}
