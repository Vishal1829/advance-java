package org.advancedjava.lombokdemo;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Car extends Vehicle{
    private int seatCount;

    public static void main(String[] args) {
        Car car = Car.builder()
                .make("Honda")
                .model("Toyota")
                .seatCount(4)
                .build();
    }
}
