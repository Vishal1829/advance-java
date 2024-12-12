package org.advancedjava.designpattern.behavioral.command.acex;

public class AirConditioner {
    private boolean isOn;
    private int temperature;

    public void turnOnAC() {
        this.isOn = true;
        System.out.println("AC is ON");
    }

    public void turnOffAC() {
        this.isOn = false;
        System.out.println("AC is OFF");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Temperature changed to: " + this.temperature);
    }
}
