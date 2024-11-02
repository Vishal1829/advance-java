package org.advancedjava.designpattern.creational.abstractfactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactoryObj = AbstractFactoryProducer.getFactoryInstance("Premium");
        Car carObj = abstractFactoryObj.getInstance(5000000);
        System.out.println(carObj.getTopSpeed());
    }
}
/*
Abstract Factory Pattern:
It's a Factory of Factory.

Here for the above ex, to understand it properly start analyzing from bottom so:
Simple Car is an interface, and it has 4 concrete classes of which it is categorized in two categories ->
economic and luxury. Now we can create a simple factory object and get the objects for all these 4 concrete classes
but here if we want to get the object based on category then we need to create a factory of factory how?
so first we just create a factory interface which return an instance of a Car concrete object based on price
now these abstractfactory interface will have 2 concrete classed based on category and category here in this
context can be classified based on price so one will be economical and other will be luxury or premium. Now
these 2 concrete classes will return the specific category object of Car concrete classes. Now finally
since we have the interface of abstract factory now we need a class which will give us object of factory concrete
classes so this new class will be the factory object producer and once we get the factory object we then get the
concrete Car class object based on category via price.
Flow:
getAbstractFactoryObject -> getCategoryBasedObject -> getCarConcreteObject
AbstractFactoryProducer.getFactoryInstance("Economic"); -> EconomicCarFactory (AbstractFactory interface concrete class)
EconomicCarFactory.getInstance(100000); -> EconomicCar1 (Car interface concrete class object)
 */