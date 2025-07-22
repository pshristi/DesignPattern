package com.example.learninglld.strategyOrBridgePattern.withStrategyPattern;

import com.example.learninglld.strategyOrBridgePattern.withStrategyPattern.strategy.SportsDrivingStrategy;

public class OffroadVehicle extends Vehicle {
   OffroadVehicle() {
       super(new SportsDrivingStrategy());
   }
}
