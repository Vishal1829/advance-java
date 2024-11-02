package org.advancedjava.designpattern.creational.builder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student = Student.builder() // this will give StudentBuilder Object
                .name("Vishal")  // it will call StudentBuilder name method
                .rollNumber(1289)  // it will call StudentBuilder rollNumber method
                .subjects(List.of("Maths", "Computer Science", "English")) // it will call StudentBuilder subjects method
                .build();   // it will call StudentBuilder build method which gives
                            // the actual Student object will all values present in StudentBuilder object.
        System.out.println(student);
    }
}
