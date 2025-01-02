package org.advancedjava.lld.parkinglot2.factory;

import org.advancedjava.lld.parkinglot2.model.Color;
import org.advancedjava.lld.parkinglot2.model.VehicleType;
import org.advancedjava.lld.parkinglot2.model.Bike;
import org.advancedjava.lld.parkinglot2.model.Car;
import org.advancedjava.lld.parkinglot2.model.Truck;
import org.advancedjava.lld.parkinglot2.model.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String regNo, String color) {
        return switch (VehicleType.valueOf(vehicleType)) {
            case CAR -> new Car(regNo, Color.valueOf(color));
            case BIKE -> new Bike(regNo, Color.valueOf(color));
            case TRUCK -> new Truck(regNo, Color.valueOf(color));
        };
    }
}
