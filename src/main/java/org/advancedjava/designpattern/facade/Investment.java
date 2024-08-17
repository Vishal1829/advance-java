package org.advancedjava.designpattern.facade;

import java.math.BigDecimal;

public class Investment extends Account {
    public Investment(final BigDecimal balance) {
        super(balance);
    }

    @Override
    public void deposit(final BigDecimal amount) {
        this.setBalance(this.getBalance().add(amount));
    }

    @Override
    public void withdraw(final BigDecimal amount) {
        this.setBalance(this.getBalance().subtract(amount));
    }

    @Override
    public void transfer(Account toAccount, BigDecimal amount) {
        this.withdraw(amount);
        toAccount.deposit(amount);
    }
}

