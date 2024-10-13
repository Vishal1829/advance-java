package org.advancedjava.lld.snakeladder.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {
    private final String name;
    private final String id;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
