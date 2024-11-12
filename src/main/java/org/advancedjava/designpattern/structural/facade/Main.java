package org.advancedjava.designpattern.structural.facade;

public class Main {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade();
        bankingFacade.getAccountDetails("123456");
        bankingFacade.transferFunds("123456", "654321", 100.0);
        bankingFacade.payBill("123456", "BILL001", 50.0);
    }
}
/*
Facade Design Pattern:
The Facade Design Pattern is a structural pattern that provides a simplified interface to a set of interfaces
in a subsystem, making it easier to use. It involves creating a unified interface that sits on top of a set of
interfaces to simplify the usage for clients.

Steps:
Step 1-: Create all necessary services (Account Service, Transfer Service, Bill Payment Service)
Step 2-: Create Facade (Bank Facade)
Step 3-: Create Main Class (Main Class)

The banking system employs a set of services to manage accounts, transfer funds, and handle bill payments.
The AccountService retrieves account details based on the provided account ID. TransferService facilitates the
transfer of funds between accounts, involving database updates or external API calls. Similarly, BillPaymentService
handles bill payments from specified accounts, potentially involving database modifications or external service
interactions. To simplify client interactions, the BankingFacade abstracts these services, providing a straightforward
interface for accessing account details, transferring funds, and paying bills. The client, represented by the Main
class, utilizes the facade methods to perform these operations without needing to manage the intricacies of individual
services directly, enhancing code readability and maintainability.

Real ex: Spring JdbcTemplate is an example of facade design pattern as we just have to specify the jdbc connection url
it will take care of it whether mysql, oracle, etc. it will handle, and we can perform all db operations.

https://medium.com/@akshatsharma0610/facade-design-pattern-in-java-777005efc75f
 */
