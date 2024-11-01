package org.advancedjava.designpattern.behavioral.template.paymentflow;

public abstract class PaymentFlow {

    protected abstract void validateRequest();
    protected abstract void calculateFees();
    protected abstract void debitAmount();
    protected abstract void creditAmount();

    //this is Template method: which defines the order of steps to execute the task.
    public final void sendMoney() {
        //step1
        validateRequest();

        //step2
        calculateFees();

        //step3
        debitAmount();

        //step4
        creditAmount();
    }
}
