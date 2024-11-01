package org.advancedjava.designpattern.behavioral.template.paymentflow;

public class Client {
    public static void main(String[] args) {
        PaymentFlow paymentFlow = new PayToFriend();
        paymentFlow.sendMoney();
        System.out.println();
        paymentFlow = new PayToMerchant();
        paymentFlow.sendMoney();
    }
}

/*
Steps for Template design pattern:-
1. Define an abstract class which will have a final method in which the steps will be mentioned in
a particular order.
2. Then create concrete classes which implements the abstract class and this concrete classes can
implement the methods for a particular step according to their behaviour.
 */
