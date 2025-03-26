package org.advancedjava.interviewquestions.multipleinheritance.solution2;

// Class B using composition
public class B extends LibraryClass {
    private A aInstance;

    public B() {
        this.aInstance = new A(); // Compose with an instance of A
    }

    // Delegate method calls to A
    public void methodFromA() {
        aInstance.methodFromA();
    }

    public static void main(String[] args) {
        B b = new B();
        b.libraryMethod();  // From LibraryClass
        b.methodFromA();    // Delegated to A
    }
}
/*
Q:- Multiple inheritance, also lets say we have a class from a library lets say it is called LibraryClass
and since its a library class we cannot modify it and we have other two classes A and B and now B wants
to inherit from both A and library class how can we achieve this in java.

Solution 2: Use Composition
If A has specific functionality (methods or state) that you need in B, and you can’t
modify A into an interface, you can use composition. This means B extends LibraryClass
and contains an instance of A to delegate calls to A’s methods.

Explanation:
- B extends LibraryClass, so it inherits its methods.
- B has an instance of A as a field and delegates calls to A’s methods.
- This approach avoids inheritance from A entirely and works even if A and LibraryClass are both unmodifiable.

Note: composition is flexible so we can also do this we extends from A and apply composition on
LibraryClass.


A good answer could be:
"Java doesn’t allow multiple inheritance of classes, so B can’t directly extend both LibraryClass and A.
However, I’d solve this by having B extend LibraryClass and either implement an interface that defines
A’s behavior or use composition by including an instance of A in B and delegating calls to it.
The choice depends on whether I need A’s behavior as a contract (interface) or its full implementation (composition)."
 */