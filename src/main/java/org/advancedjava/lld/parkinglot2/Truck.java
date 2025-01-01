package org.advancedjava.lld.parkinglot2;

public class Truck implements Vehicle {
    private final VehicleType type;
    private final String regNo;
    private final Color color;

    public Truck(String regNo, Color color) {
        this.type = VehicleType.TRUCK;
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

