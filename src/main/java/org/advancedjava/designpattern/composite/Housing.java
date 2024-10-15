package org.advancedjava.designpattern.composite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Housing implements Structure{
    private List<Structure> structures;
    private String address;

    public Housing(String address) {
        this.structures = new ArrayList<>();
        this.address = address;
    }

    @Override
    public String getName() {
        return this.address;
    }

    public int addStructure(final Structure component) {
        this.structures.add(component);
        return this.structures.size() - 1;
    }

    public Structure getStructure(int componentNumber) {
        return this.structures.get(componentNumber);
    }

    @Override
    public void enter() {
        log.info("Entering in {}", this.getName());
    }

    @Override
    public void exit() {
        log.info("Exiting from {}", this.getName());
    }

    @Override
    public void location() {
        log.info("You are currently in {}. It has", this.getName());
        structures.forEach(component -> log.info("{}", component.getName()));
    }

}
