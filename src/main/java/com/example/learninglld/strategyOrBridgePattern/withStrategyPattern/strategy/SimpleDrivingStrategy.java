package com.example.learninglld.strategyOrBridgePattern.withStrategyPattern.strategy;

public class SimpleDrivingStrategy implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("Simple driving capability");
    }
}
