package org.advancedjava.designpattern.structural.adapter.printer;

public class Client {

    public static void main(String[] args) {
        // Using the LegacyPrinter as a NewPrinter through the adapter
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        NewPrinter newPrinter = new LegacyPrinterAdapter(legacyPrinter);

        // Client code can now use the NewPrinter interface
        newPrinter.sendMessage("Hello, Adapter Pattern!");
    }
}
/*
In the above UML class diagram, the client class that requires a target interface cannot reuse the adaptee
class directly because its interface doesn't conform to the target interface. Instead, the client works
through an adapter class that implements the target interface in terms of adaptee:

The Adapter pattern involves a single class called the Adapter, which is responsible for joining functionalities
of independent or incompatible interfaces.

The components of the Adapter pattern:

Target Interface: This is the interface that the client code expects to interact with. It’s the interface
that your client code uses.
Adaptee: This is the class that has the functionality that the client code wants to use, but it doesn’t
conform to the target interface.
Adapter: This is the class that bridges the gap between the Target Interface and the Adaptee.
It implements the Target Interface and delegates the calls to the Adaptee.


Steps to Implement:

1. Make sure that you have at least two classes with incompatible interfaces:
- A useful service class, which you can’t change (often 3rd-party, legacy or with lots of existing dependencies).
- One or several client classes that would benefit from using the service class.

2. Declare the client interface and describe how clients communicate with the service.

3. Create the adapter class and make it follow the client interface. Leave all the methods empty for now.

4. Add a field to the adapter class to store a reference to the service object. The common practice is to
initialize this field via the constructor, but sometimes it’s more convenient to pass it to the adapter when
calling its methods.

5. One by one, implement all methods of the client interface in the adapter class. The adapter should delegate
most of the real work to the service object, handling only the interface or data format conversion.

6. Clients should use the adapter via the client interface. This will let you change or extend the adapters
without affecting the client code.
 */
