package org.advancedjava.designpattern.behavioral.template.paymentflow;

public class PayToFriend extends PaymentFlow {

    @Override
    protected void validateRequest() {
        //specific validation for PayToFriend flow
        System.out.println("Validate logic of PayToFriend");
    }

    @Override
    protected void calculateFees() {
        //specific fee computation logic for PayToFriend flow
        System.out.println("0% fees charged");
    }

    @Override
    protected void debitAmount() {
        //debit the amount
        System.out.println("Debit the Amount logic of PayToFriend");
    }

    @Override
    protected void creditAmount() {
        //credit the amount
        System.out.println("Credit the full amount");
    }
}
