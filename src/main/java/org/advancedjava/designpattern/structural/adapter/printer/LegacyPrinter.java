package org.advancedjava.designpattern.structural.adapter.printer;

// Adaptee: LegacyPrinter
public class LegacyPrinter {

    public void printMessage(String message) {
        System.out.println("Legacy Printer: " + message);
    }
}
