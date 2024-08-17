package org.advancedjava.designpattern.facade;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BankService {
    private final Map<String, Account> bankAccounts;
    public BankService() {
        bankAccounts = new HashMap<>();
    }
    public String createNewAccount(final String type, final BigDecimal initAmount) {
        Account newAccount = null;
        switch (type) {
            case "saving":
                newAccount = new Saving(initAmount);
                break;
            case "investment":
                newAccount = new Investment(initAmount);
                break;
            default:
                log.error("Invalid account type");
                break;
        }
        if (newAccount != null) {
            this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
            return newAccount.getAccountNumber();
        }
        return null;
    }
    public void transferMoney(final String from, final String to, final BigDecimal amount) {
        Account toAccount = this.bankAccounts.get(to);
        Account fromAccount = this.bankAccounts.get(from);
        fromAccount.transfer(toAccount, amount);
    }
    public String checkAccountBalance(final String accNum) {
        return bankAccounts.get(accNum).getBalance().toString();
    }
}
