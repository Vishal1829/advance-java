package org.advancedjava.designpattern.facade;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/*
Here Customer is out client and BankService is the facade class which wraps all the classes which implements Account
Interface. Here the customer(client) interaction will be smooth as he or she doesn't have to manage the accounts directly.

https://www.notion.so/Coursera-Design-Patterns-91c225be182b480cb36d3fb7ba857e5b?pvs=4#a348974924cb400ebf10499ccc67a427
 */

@Slf4j
public class Customer {
    public static void main(String[] args) {
        final BankService myBankService = new BankService();

        final String mySaving = myBankService.createNewAccount("saving", new BigDecimal("5000.25"));
        final String myInvestment = myBankService.createNewAccount("investment", new BigDecimal("60000.75"));
        log.info("Before transfer : Saving Balance - {}, Investment Balance - {}", myBankService.checkAccountBalance(mySaving),
                myBankService.checkAccountBalance(myInvestment));
        myBankService.transferMoney(mySaving, myInvestment, new BigDecimal("3000"));
        log.info("After transfer : Saving Balance - {}, Investment Balance - {}", myBankService.checkAccountBalance(mySaving),
                myBankService.checkAccountBalance(myInvestment));
    }
}

/*
Key design principles used to implement facade design patter:
Encapsulation, information hiding, separation of concerns

While the facade design pattern uses a number of different design principles, its purpose is to provide ease of access
to a complex subsystem. This is done by encapsulating the subsystem classes into a facade class, and then hiding them
from the clients classes so that the clients do not know about the details of the subsystem.

Steps to follow:-
1. Design the interface
2. Implement the interface with one or more classes
3. Create the facade class and wrap the classes that implement the interface
4. Use the facade class to access the subsystem

Note: A facade class can be used to wrap all the interfaces and classes for a subsystem.
 */