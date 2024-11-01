package org.advancedjava.designpattern.behavioral.command;

public class MyRemoteControl {

    ICommand command;
    public MyRemoteControl() {

    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
