package org.advancedjava.designpattern.behavioral.strategy;

public class CreditCardStartegy implements PayStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("paying " + amount + " via credit card");
    }
}
