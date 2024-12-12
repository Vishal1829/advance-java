package org.advancedjava.designpattern.behavioral.command.lightex;

// Concrete Command to turn off the light
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
