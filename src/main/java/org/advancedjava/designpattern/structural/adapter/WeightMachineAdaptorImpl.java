package org.advancedjava.designpattern.structural.adapter;

public class WeightMachineAdaptorImpl implements WeightMachineAdaptor {

    private final WeightMachine machine;

    public WeightMachineAdaptorImpl(WeightMachine machine) {
        this.machine = machine;
    }

    @Override
    public int getWeightInKg() {
        int weightInPounds = machine.getWeightInPounds();
        return (int) (weightInPounds * 0.45);
    }
}
