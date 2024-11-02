package org.advancedjava.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Composite Class - Department
public class Department implements Employee {
    private String name;
    private List<Employee> employees;
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}
