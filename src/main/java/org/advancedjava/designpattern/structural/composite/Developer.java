package org.advancedjava.designpattern.structural.composite;

// Leaf Class - Developer
public class Developer implements Employee {
    private String name;
    private String position;
    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }
    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}
