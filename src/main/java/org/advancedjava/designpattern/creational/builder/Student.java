package org.advancedjava.designpattern.creational.builder;

import lombok.ToString;

import java.util.List;

@ToString
public class Student {
    private String name;
    private int rollNumber;
    private List<String> subjects;

    Student(String name, int rollNumber, List<String> subjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private String name;
        private int rollNumber;
        private List<String> subjects;

        StudentBuilder() {
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder rollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public StudentBuilder subjects(List<String> subjects) {
            this.subjects = subjects;
            return this;
        }

        public Student build() {
            return new Student(this.name, this.rollNumber, this.subjects);
        }

    }
}
