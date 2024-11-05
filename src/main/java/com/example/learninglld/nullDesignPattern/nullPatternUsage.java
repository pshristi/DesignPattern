package com.example.learninglld.nullDesignPattern;

public class nullPatternUsage {
    public void useNullPattern() {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle1 = vehicleFactory.createVehicle("Car");
        System.out.println("Seating capacity: " + vehicle1.getSeatingCapacity());

        Vehicle vehicle2 = vehicleFactory.createVehicle("Bike");
        System.out.println("Seating capacity: " + vehicle2.getSeatingCapacity());
    }
}
