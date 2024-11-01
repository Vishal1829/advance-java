package org.advancedjava.designpattern.behavioral.chainofresponsibility;

public class Dollar20Dispenser implements DispenceChain {

    private DispenceChain chain;

    @Override
    public void setNextChain(DispenceChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispence(Currency currency) {
        if(currency.getAmount() >= 20){
            int num = currency.getAmount()/20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing " + num + " 20$ note");
            currency.setAmount(remainder);
            if(remainder != 0)
                this.chain.dispence(currency);
        }else{
            this.chain.dispence(currency);
        }
    }
}

