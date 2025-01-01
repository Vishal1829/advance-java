package org.advancedjava.lld.parkinglot2;

import java.util.Map;

public interface SlotDistributionStrategy {
    Map<VehicleType, Integer> getDistribution(int numSlots);
}
