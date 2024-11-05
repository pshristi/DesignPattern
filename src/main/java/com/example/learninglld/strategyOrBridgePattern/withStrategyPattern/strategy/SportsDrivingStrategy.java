package com.example.learninglld.strategyOrBridgePattern.withStrategyPattern.strategy;

public class SportsDrivingStrategy implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("Sports driving capability");
    }
}
