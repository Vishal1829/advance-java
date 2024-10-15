package org.advancedjava.designpattern.composite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Room implements Structure{
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void enter() {
        log.info("You have entered the {}", this.getName());
    }

    @Override
    public void exit() {
        log.info("You have left the {}", this.getName());
    }

    @Override
    public void location() {
        log.info("You are currently in {}", this.getName());
    }

}
