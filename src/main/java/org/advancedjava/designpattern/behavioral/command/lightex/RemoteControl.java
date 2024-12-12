package org.advancedjava.designpattern.behavioral.command.lightex;

// Invoker
public class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}
