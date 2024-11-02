package org.advancedjava.designpattern.creational.prototype;

public class Main {
    public static void main(String[] args) {
        Student obj = new Student(20, 75, "Ravi");

//        creating clone of obj
//        Student cloneObj = new Student();
//        cloneObj.name = obj.name;
//        cloneObj.age = obj.age;
//        cloneObj.rollNumber = obj.rollNumber;

        Student cloneObj = (Student) obj.clone();
        System.out.println(cloneObj);
    }
}
/*
Prototype Pattern:
It is used when we have to make Copy/Clone from Existing Object.

cloning logic should not be the responsibility of the client but the class itself here student class
should have a clone method.
 */