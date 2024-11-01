package org.advancedjava.designpattern.behavioral.template.paymentflow;

public class PayToMerchant extends PaymentFlow {

    @Override
    protected void validateRequest() {
        //specific validation for PayToMerchant flow
        System.out.println("Validate logic of PayToMerchant");
    }

    @Override
    protected void calculateFees() {
        //specific fee computation logic for PayToMerchant flow
        System.out.println("2% fees charged");
    }

    @Override
    protected void debitAmount() {
        //debit the amount
        System.out.println("Debit the Amount logic of PayToMerchant");
    }

    @Override
    protected void creditAmount() {
        //credit the amount
        System.out.println("Credit the remaining amount");
    }
}

