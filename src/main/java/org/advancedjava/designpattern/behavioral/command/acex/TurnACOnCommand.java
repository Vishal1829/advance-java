package org.advancedjava.designpattern.behavioral.command.acex;

public class TurnACOnCommand implements ICommand {

    private AirConditioner ac;
    public TurnACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.turnOnAC();
    }
}
