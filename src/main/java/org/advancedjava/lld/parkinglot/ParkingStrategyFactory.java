package org.advancedjava.lld.parkinglot;

public class ParkingStrategyFactory {
    public static ParkingStrategy getParkingStrategy(String strategyType) {
        return switch (strategyType.toLowerCase()) {
            case "nearest" -> new NearestSlotStrategy();
            case "furthest" -> new FurthestSlotStrategy(); // Hypothetical future strategy
            default -> throw new IllegalArgumentException("Unknown parking strategy: " + strategyType);
        };
    }
}

