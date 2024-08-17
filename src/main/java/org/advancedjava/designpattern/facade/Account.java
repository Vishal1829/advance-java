package org.advancedjava.designpattern.facade;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public abstract class Account {
    private BigDecimal balance;
    private final String accountNumber;

    public Account(final BigDecimal balance) {
        this.balance = balance;
        this.accountNumber = UUID.randomUUID().toString();
    }

    public abstract void deposit(BigDecimal amount);
    public abstract void withdraw(BigDecimal amount);
    public abstract void transfer(Account toAccount, BigDecimal amount);
}
