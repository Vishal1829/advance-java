package org.advancedjava.lld.parkinglot2;

import java.util.Map;

public class CustomSlotDistributionStrategy implements SlotDistributionStrategy {
    private final Map<Integer, Map<VehicleType, Integer>> perFloorDistribution;

    public CustomSlotDistributionStrategy(final Map<Integer, Map<VehicleType, Integer>> perFloorDistribution) {
        this.perFloorDistribution = perFloorDistribution;
    }

    @Override
    public Map<VehicleType, Integer> getDistribution(int floorNumber, int numSlots) {
        return perFloorDistribution.get(floorNumber);
    }
}
