package org.advancedjava.designpattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private PayStrategy payObj;
    private final List<String> items = new ArrayList<>();

    public void addItems(String item) {
        items.add(item);
    }

    private void setPayMethod(String payMethod) {
        switch (payMethod) {
            case "cash":
                payObj = new CashStrategy();
                break;
            case "creditcard":
                payObj = new CreditCardStartegy();
                break;
            case "upi":
                payObj = new UPIStrategy();
                break;
            default:
                payObj = new CashStrategy();
        }
    }
    public void pay(String payMethod, int amount) {
        setPayMethod(payMethod);
        payObj.pay(amount);
    }
}
