package org.advancedjava.designpattern.behavioral.chainofresponsibility;

public interface DispenceChain {
    void setNextChain(DispenceChain nextChain);
    void dispence(Currency currency);
}
