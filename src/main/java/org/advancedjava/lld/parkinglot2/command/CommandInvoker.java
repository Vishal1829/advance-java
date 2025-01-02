package org.advancedjava.lld.parkinglot2.command;

public class CommandInvoker {
    public void executeCommand(Command command) {
        command.execute();
    }
}
