package org.advancedjava.interviewquestions.multipleinheritance.solution1;

// Class B inheriting from LibraryClass and implementing InterfaceA
public class B extends LibraryClass implements InterfaceA {
    @Override
    public void methodFromA() {
        System.out.println("B's implementation of method from A");
    }

    public static void main(String[] args) {
        B b = new B();
        b.libraryMethod();  // From LibraryClass
        b.methodFromA();    // From InterfaceA
    }
}
/*
Q:- Multiple inheritance, also lets say we have a class from a library lets say it is called LibraryClass
and since its a library class we cannot modify it and we have other two classes A and B and now B wants
to inherit from both A and library class how can we achieve this in java.

Solution 1: Use Interfaces
Java allows a class to implement multiple interfaces, so you can extract the behavior of A into an interface and have B extend LibraryClass while implementing that interface.

Steps:
- Define an interface (e.g., InterfaceA) that captures the behavior or contract of A.
- Make A implement InterfaceA (if you control A and can modify it).
- Have B extend LibraryClass and implement InterfaceA.

Explanation:
- B directly inherits from LibraryClass, gaining its functionality.
- B implements InterfaceA, allowing it to define methodFromA() and mimic A’s behavior.
- If A has implementation details you need in B, you can either duplicate the logic in B or
use composition (see Solution 2).
 */
