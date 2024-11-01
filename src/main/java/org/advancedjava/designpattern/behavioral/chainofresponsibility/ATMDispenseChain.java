package org.advancedjava.designpattern.behavioral.chainofresponsibility;

public class ATMDispenseChain {

    private final DispenceChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenceChain c2 = new Dollar20Dispenser();
        DispenceChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        Currency currency = new Currency(110);
        while (currency.getAmount() > 0) {
            if (currency.getAmount() % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispence(currency);
        }
    }
}

/*
Chain of responsibility pattern is used to achieve loose coupling in software design
where a request from client is passed to a chain of objects to process them.
Then the object in the chain will decide themselves who will be processing the request
and whether the request is required to be sent to the next object in the chain or not.

A good example in java itself:
the try-catch blocks - every catch block is kind of a processor to process that
particular exception. So when any exception occurs in the try block, its send to the
first catch block to process. If the catch block is not able to process it, it forwards
the request to next object in chain i.e., next catch block. If even the last catch block
is not able to process it, the exception is thrown outside the chain to the calling program.

Another ex:
A request which pass through a chain of filters.
 */