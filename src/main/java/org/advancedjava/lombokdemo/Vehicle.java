package org.advancedjava.lombokdemo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Vehicle {
    private String make;
    private String model;
}
