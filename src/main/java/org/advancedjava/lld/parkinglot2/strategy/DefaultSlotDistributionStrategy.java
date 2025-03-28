package org.advancedjava.lld.parkinglot2.strategy;

import org.advancedjava.lld.parkinglot2.model.VehicleType;

import java.util.EnumMap;
import java.util.Map;

public class DefaultSlotDistributionStrategy implements SlotDistributionStrategy {
    @Override
    public Map<VehicleType, Integer> getDistribution(int floorNumber, int numSlots) {
        Map<VehicleType, Integer> distribution = new EnumMap<>(VehicleType.class);
        distribution.put(VehicleType.TRUCK, 1);
        distribution.put(VehicleType.BIKE, 2);
        distribution.put(VehicleType.CAR, numSlots - 3);
        return distribution;
    }
}
