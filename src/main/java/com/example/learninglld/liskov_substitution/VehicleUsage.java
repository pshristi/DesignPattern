package com.example.learninglld.liskov_substitution;

import java.util.ArrayList;
import java.util.List;

public class VehicleUsage {
    public static void useVehicle() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Bicycle());

        for (Vehicle vehicle : vehicles) {
            //It will break the code as my child Bicycle is not extending capabilities of Vehicle but restricting it
            System.out.println(vehicle.hasEngine().toString());
        }
    }
}
