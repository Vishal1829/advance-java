package org.advancedjava.designpattern.structural.adapter.printer;

// Adapter: LegacyPrinterAdapter
public class LegacyPrinterAdapter implements NewPrinter {

    // Adaptee instance
    private final LegacyPrinter legacyPrinter;

    public LegacyPrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    // Implementing the Target Interface by delegating the call to Adaptee
    @Override
    public void sendMessage(String message) {
        legacyPrinter.printMessage(message);
    }
}
