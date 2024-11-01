package org.advancedjava.designpattern.behavioral.command;

public class Client {
    public static void main(String[] args) {
        //AC object
        AirConditioner airConditioner = new AirConditioner();
//        steps: s1,s2,s3
//        airConditioner.turnOnAC();
//        airConditioner.setTemperature(24);
//        airConditioner.turnOffAC();

        //better way below using command design pattern.

        //remote
        MyRemoteControl remoteObj = new MyRemoteControl();

        //create command and press the button
        remoteObj.setCommand(new TurnACOnCommand(airConditioner));
        remoteObj.pressButton();
    }
}
/*
Command Pattern: Turns requests (commands) into objects, allowing you to either parameterized
or queue them. This will help to decouple the request Sender and Receiver.

Process of turing on AC is simple, but if there are more steps, client has to aware all of that,
which is not good. So Sender and Receiver are not decoupled.
 */
