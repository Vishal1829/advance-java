package org.advancedjava.lld.parkinglot2.model;

public class Car implements Vehicle {
    private final VehicleType type;
    private final String regNo;
    private final Color color;

    public Car(String regNo, Color color) {
        this.type = VehicleType.CAR;
        this.regNo = regNo;
        this.color = color;
    }

    @Override
    public VehicleType getVehicleType() {
        return type;
    }

    @Override
    public String getRegNo() {
        return regNo;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
