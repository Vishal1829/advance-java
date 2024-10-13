package org.advancedjava.lld.snakeladder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Getter
@Setter
public class Board {
    private int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private Map<String, Integer> playersPosition;

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.playersPosition = new HashMap<>();
    }

    public void setPlayersPosition(final Queue<Player> players) {
        players.forEach(player -> playersPosition.put(player.getId(), 0));
    }
}
