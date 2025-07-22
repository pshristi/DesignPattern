package com.example.learninglld.strategyOrBridgePattern.withoutStrategyPattern;

public class OffroadVehicle extends Vehicle{
    @Override
    public void drive() {
        //This is leading to duplicate code in OffroadVehicle and SportsVehicle classes
        System.out.println("Sports driving capability");
    }
}
