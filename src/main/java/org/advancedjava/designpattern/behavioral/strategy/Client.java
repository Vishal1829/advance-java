package org.advancedjava.designpattern.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItems("carrot");
        shoppingCart.addItems("ladyfinger");
        shoppingCart.addItems("cabbage");
        shoppingCart.pay("upi", 100);
    }
}
/*
Strategy Pattern: helps to define multiple implementations for the task and we can select any
implementation depending on the situation.
 */