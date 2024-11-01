package org.advancedjava.designpattern.behavioral.strategy;

public class CashStrategy implements PayStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("paying " + amount + " via cash");
    }
}
