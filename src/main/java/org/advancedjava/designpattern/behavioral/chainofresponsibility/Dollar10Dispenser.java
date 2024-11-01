package org.advancedjava.designpattern.behavioral.chainofresponsibility;

public class Dollar10Dispenser implements DispenceChain {

    private DispenceChain chain;

    @Override
    public void setNextChain(DispenceChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispence(Currency currency) {
        if(currency.getAmount() >= 10){
            int num = currency.getAmount()/10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note");
            currency.setAmount(remainder);
            if(remainder != 0)
                this.chain.dispence(currency);
        }else{
            this.chain.dispence(currency);
        }
    }
}

