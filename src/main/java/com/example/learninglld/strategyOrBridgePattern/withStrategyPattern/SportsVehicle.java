package com.example.learninglld.strategyOrBridgePattern.withStrategyPattern;

import com.example.learninglld.strategyOrBridgePattern.withStrategyPattern.strategy.SportsDrivingStrategy;

public class SportsVehicle extends Vehicle {
   SportsVehicle() {
       super(new SportsDrivingStrategy());
   }
}
