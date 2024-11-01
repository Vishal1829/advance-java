package org.advancedjava.designpattern.behavioral.command;

public class TurnACOffCommand implements ICommand {

    private AirConditioner ac;
    public TurnACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.turnOffAC();
    }
}
