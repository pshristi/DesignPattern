package com.example.learninglld.nullDesignPattern;

public class VehicleFactory {
    public Vehicle createVehicle(String vehicleType) {
        switch (vehicleType) {
            case "Car" :
                return new Car();
            default:
                return new NullVehicle();
        }
    }
}
