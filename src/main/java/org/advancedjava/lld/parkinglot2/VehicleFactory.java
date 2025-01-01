package org.advancedjava.lld.parkinglot2;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String regNo, String color) {
        return switch (VehicleType.valueOf(vehicleType)) {
            case CAR -> new Car(regNo, Color.valueOf(color));
            case BIKE -> new Bike(regNo, Color.valueOf(color));
            case TRUCK -> new Truck(regNo, Color.valueOf(color));
        };
    }
}
