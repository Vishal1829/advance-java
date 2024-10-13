package org.advancedjava.lld.snakeladder;

import org.advancedjava.lld.snakeladder.model.Ladders;
import org.advancedjava.lld.snakeladder.model.Snakes;

import java.util.List;

public class Client {
    public static void main(String[] args) {

        Game game = new Game();

        game.initializeGame(100, 1);
        game.setSnakes(List.of(new Snakes(99, 25), new Snakes(88, 54), new Snakes(29, 10)));
        game.setLadders(List.of(new Ladders(14, 28), new Ladders(55, 97), new Ladders(42, 78), new Ladders(52, 92)));
        game.setPlayers(List.of("John", "Jane"));

        game.startGame();
    }
}
/*
https://towardsdev.com/lld-system-design-series-snake-and-ladders-in-go-a5f34887a14b

Problem Statement:
The goal of the game is simple: Players roll a dice and move forward on a 100-cell board.
The challenge lies in navigating the snakes and ladders. If a player lands on a snake’s head, they slide
down to its tail. If they land at the base of a ladder, they climb to the top. The first player to land
exactly on the 100th cell wins.

Inputs
The game accepts input in the following format:

1. Number of snakes: Followed by snake positions, each represented by the head and tail coordinates.
2. Number of ladders: Followed by ladder positions, each represented by start and end coordinates.
3. Number of players: Followed by player names.

Example Input:
3
14 7
98 79
63 60
2
8 32
36 44
3
Alice
Bob
Charlie

In this example:

- 3 snakes: head at 14, 98, 63 (tails at 7, 79, 60).
- 2 ladders: start at 8, 36 (ends at 32, 44).
- 3 players: Alice, Bob, and Charlie.

Game Rules:
1. Each player rolls a dice (range: 1–6) in turn.
2. Players move forward by the value of the dice.
3. If a player lands on the head of a snake, they slide down to its tail.
4. If a player lands at the base of a ladder, they climb up to its top.
5. If a dice roll moves a player beyond 100, they stay in their current position.
6. The first player to reach exactly 100 wins.

Solution Approach
Defining Core Entities
To model the game, we need to represent the following:

1. Board: This contains the positions of snakes and ladders.
2. Player: This stores each player’s name and their current position.
3. Game: This handles the game mechanics, including dice rolls and player turns.

Logic Flow
1. Board Setup:
- Snakes and ladders are defined by a start and an end position.
- We’ll use maps in Go to represent these snakes and ladders, making it easy to check whether a player
  lands on a snake or ladder.
2. Player Movement:
- For each turn, the player rolls a dice, moves forward, and checks if they landed on a snake or ladder.
  If so, their position is adjusted accordingly.
3. Dice Roll:
- A random dice roll generates a number between 1 and 6. The player’s position is updated based on the dice value.
4. Winning Condition:
- A player wins by landing exactly on the 100th cell. If the dice roll would move the player beyond 100,
  they remain in their current position.


- rollDice() function generates a random number between 1 and number of dices * 6
- movePlayer() function moves the player forward and checks if they landed on a snake or ladder.
- hasPlayerWon() function checks if the current user has completed the game
- isGameCompleted() function checks if the game is completed or not.

Step 4: Game Loop
- Finally, we’ll implement the game loop that keeps the game running until a player wins.
 */
