package org.advancedjava.lld.parkinglot2;

public class Bike implements Vehicle {
    private final VehicleType type;
    private final String regNo;
    private final Color color;

    public Bike(String regNo, Color color) {
        this.type = VehicleType.BIKE;
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

