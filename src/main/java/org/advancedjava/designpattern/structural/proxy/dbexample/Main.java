package org.advancedjava.designpattern.structural.proxy.dbexample;

public class Main {
    public static void main(String[] args) {

        DataBaseExecutor emp1 = new DataBaseProxy("NON ADMIN");
        emp1.executeQuery("READ");
        emp1.executeQuery("WRITE");
        emp1.executeQuery("DELETE");

        DataBaseExecutor emp2 = new DataBaseProxy("ADMIN");
        emp2.executeQuery("READ");
        emp2.executeQuery("WRITE");
        emp2.executeQuery("DELETE");

    }
}
/*
Proxy Design Pattern:
Proxy Design Pattern is a structural design pattern that lets you provide a substitute or placeholder for
another object to control access to it .

The Proxy pattern involves creating a class that acts as an intermediary between a client and a real object.
It provides an interface identical to the original object, allowing clients to interact with the proxy object as
if it were the real object. The proxy object then handles the requests and, if necessary, forwards them to the real object.
 */