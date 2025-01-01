package org.advancedjava.lld.parkinglot2;

import java.util.Map;

public class CustomSlotDistributionStrategy implements SlotDistributionStrategy {
    private final Map<VehicleType, Integer> customDistribution;

    public CustomSlotDistributionStrategy(Map<VehicleType, Integer> customDistribution) {
        this.customDistribution = customDistribution;
    }

    @Override
    public Map<VehicleType, Integer> getDistribution(int numSlots) {
        return customDistribution;
    }
}
