package org.advancedjava.designpattern.creational.abstractfactory;

public class AbstractFactoryProducer {

    public static AbstractFactory getFactoryInstance(String value) {
        return switch (value) {
            case "Economic" -> new EconomicCarFactory();
            case "Luxury", "Premium" -> new LuxuryCarFactory();
            default -> null;
        };
    }
}
