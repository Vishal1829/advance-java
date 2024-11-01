package org.advancedjava.designpattern.behavioral.chainofresponsibility;

public class Dollar50Dispenser implements DispenceChain {

    private DispenceChain chain;

    @Override
    public void setNextChain(DispenceChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispence(Currency currency) {
        if(currency.getAmount() >= 50){
            int num = currency.getAmount()/50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note");
            currency.setAmount(remainder);
            if(remainder != 0)
                this.chain.dispence(currency);
        }else{
            this.chain.dispence(currency);
        }
    }
}
