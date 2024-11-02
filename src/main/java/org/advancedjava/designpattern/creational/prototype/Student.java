package org.advancedjava.designpattern.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Student implements Prototype {

    private int age;
    private int rollNumber;
    private String name;

    @Override
    public Prototype clone() {
        return new Student(age, rollNumber, name);
    }
}
