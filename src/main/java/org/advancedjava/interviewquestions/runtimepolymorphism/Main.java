package org.advancedjava.interviewquestions.runtimepolymorphism;

class A {
    String name = "A";
    public void fun() {
        System.out.println("inside A");
    }
}

class B extends A {
    String name = "B";
    public void fun() {
        System.out.println("inside B");
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new B();
        obj.fun();
        System.out.println(obj.name);
    }
}
/*
Key Concepts: Polymorphism vs. Field Hiding
1. Runtime Polymorphism (Method Overriding)
In Java, when a subclass (B) overrides a method (fun()) from its superclass (A), the method called at runtime depends
on the actual object type, not the reference type.
Here, obj is declared as type A but points to a B object (new B()). When you call obj.fun(),
Java uses the overridden method in B because the decision is made at runtime based on the object’s actual type (B).
This is why obj.fun() outputs "inside B".

2. Field Hiding (Compile-Time Resolution)
Unlike methods, instance variables (fields like name) in Java are not polymorphic. Their access is resolved
at compile time based on the reference type, not the actual object type.
When B declares String name = "B", it doesn’t override A’s name field—it hides it. This is called field hiding.
In obj.name, the reference type of obj is A, so the compiler binds name to A’s name field, which is "A".
Even though the object is a B, the name field from B is not accessed because fields are resolved based
on the reference type (A), not the runtime type (B).

Note:
To access B’s name, you’d need:
- A reference of type B (e.g., B obj = new B()), or
- A method in B to return its name (e.g., overriding a getter), which we’ll explore below.
class A {
    String name = "A";
    public String getName() {
        return name;
    }
    public void fun() {
        System.out.println("inside A");
    }
}

class B extends A {
    String name = "B";
    @Override
    public String getName() {
        return name; // Returns B's name
    }
    public void fun() {
        System.out.println("inside B");
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new B();
        obj.fun();          // "inside B"
        System.out.println(obj.getName()); // "B"
    }
}
 */
