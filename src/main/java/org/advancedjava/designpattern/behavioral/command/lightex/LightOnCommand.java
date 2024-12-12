package org.advancedjava.designpattern.behavioral.command.lightex;

// Concrete Command to turn on the light
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
