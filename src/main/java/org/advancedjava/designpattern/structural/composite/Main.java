package org.advancedjava.designpattern.structural.composite;

public class Main {
    public static void main(String[] args) {
        Employee developer1 = new Developer("John Doe", "Senior Developer");
        Employee developer2 = new Developer("Jane Smith", "Junior Developer");

        Department department1 = new Department("Engineering");
        department1.addEmployee(developer1);
        department1.addEmployee(developer2);

        Employee developer3 = new Developer("Mike Johnson", "Senior Developer");
        Employee developer4 = new Developer("Emily Brown", "Junior Developer");
        Department department2 = new Department("Marketing");
        department2.addEmployee(developer3);
        department2.addEmployee(developer4);

        Department organization = new Department("Company");
        organization.addEmployee(department1);
        organization.addEmployee(department2);
        organization.showDetails();
    }
}
/*
Composite Design Pattern:
The Composite design pattern falls under the structural design pattern category. It allows the creation of
complex structures by treating individual objects and groups of objects in a uniform manner.
The pattern represents objects and their compositions as a tree structure, where leaf nodes represent
individual objects, and composite nodes represent groups of objects or the entire structure.

https://medium.com/@rajeshvelmani/unifying-elements-exploring-the-composite-design-pattern-in-java-73d5360c4e21
 */