package org.advancedjava.designpattern.behavioral.command.lightex;

// Client
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is ON

        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is OFF
    }
}
/*
The Command Design Pattern is a behavioural design pattern that turns a request into a stand-alone object
containing all the information about the request. This pattern allows you to parameterize objects with operations,
delay the execution of an operation, or queue a request for execution.

Explanation:
1. Command Interface: Command with the execute() method.
2. Receiver: Light with methods turnOn() and turnOff().
3. Concrete Commands: LightOnCommand and LightOffCommand implement Command and call appropriate methods on Light.
4. Invoker: RemoteControl holds a command and invokes it.
5. Client: Creates instances of Light, commands, and the remote control, sets commands, and presses the button.

https://pandac.in/blogs/command-pattern/
 */