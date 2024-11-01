package org.advancedjava.designpattern.behavioral.strategy;

public class UPIStrategy implements PayStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("paying " + amount + " via UPI");
    }
}
