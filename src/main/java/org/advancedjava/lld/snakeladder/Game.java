package org.advancedjava.lld.snakeladder;

import lombok.extern.slf4j.Slf4j;
import org.advancedjava.lld.snakeladder.model.Board;
import org.advancedjava.lld.snakeladder.model.Ladders;
import org.advancedjava.lld.snakeladder.model.Player;
import org.advancedjava.lld.snakeladder.model.Snakes;

import java.util.*;

@Slf4j
public class Game {
    private static final Random rand = new Random();
    private static final int MAX = 6;
    private static final int MIN = 1;
    private int noOfDice;
    private int noOfPlayers;
    private Board board;
    private Queue<Player> players;

    public void initializeGame(int boardSize, int noOfDice) {
        this.noOfDice = noOfDice;
        this.board = new Board(boardSize);
        this.players = new LinkedList<>();
    }

    public void setPlayers(List<String> players) {
        players.forEach(player -> this.players.add(new Player(player)));
        this.board.setPlayersPosition(this.players);
        this.noOfPlayers = players.size();
    }

    public void setSnakes(final List<Snakes> snakes) {
        snakes.forEach(snake -> this.board.getSnakes().put(snake.getStart(), snake.getEnd()));
    }

    public void setLadders(final List<Ladders> ladders) {
        ladders.forEach(ladder -> this.board.getLadders().put(ladder.getStart(), ladder.getEnd()));
    }

    public int diceRoll() {
        return rand.nextInt(MAX - MIN + 1) + MIN;
    }

    public void movePlayer(Player player, int position) {
        int oldPosition = this.board.getPlayersPosition().get(player.getId());
        int newPosition = oldPosition + position;

        int boardSize = this.board.getSize();
        newPosition = newPosition <= boardSize ? getPositionAfterTurn(newPosition) : oldPosition;

        this.board.getPlayersPosition().put(player.getId(), newPosition);
        log.info("{} rolled a {} and moved from {} to {}", player.getName(), position, oldPosition, newPosition);
    }

    public int getPositionAfterTurn(int newPosition) {
        if (this.board.getSnakes().containsKey(newPosition)) {
            return this.board.getSnakes().get(newPosition);
        } else if (this.board.getLadders().containsKey(newPosition)) {
            return this.board.getLadders().get(newPosition);
        }
        return newPosition;
    }

    public boolean hasPlayerWon(final Player player) {
        return this.board.getPlayersPosition().get(player.getId()) == this.board.getSize();
    }

    public void startGame() {
        log.info("Starting the Game.............");
        while (!isGameCompleted()) {
            int diceRoll = diceRoll();
            Player currentPlayer = this.players.poll();
            movePlayer(currentPlayer, diceRoll);
            if (hasPlayerWon(currentPlayer)) {
                log.info("Player : {} won the game", currentPlayer.getName());
            } else {
                this.players.add(currentPlayer);
            }
        }
        log.info("Ending the Game.............");
    }

    public boolean isGameCompleted() {
        int currentPlayers = this.players.size();
        return currentPlayers < this.noOfPlayers;
    }
}
