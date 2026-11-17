package com.example.tictactoe;

import com.example.tictactoe.models.*;
import com.example.tictactoe.strategy.play.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    private static final int BOARD_SIZE = 3;

    @Test
    public void testGame() {

        Game game = Game.builder().withSize(BOARD_SIZE)
                .withPlayer(new HumanPlayer(Symbol.O, new User()))
                .withPlayer(new BotPlayer(Symbol.X, Level.EASY, new RandomPlayingStrategy()))
                .build();

        assertEquals(2, game.getPlayers().size(), "if game is created, it needs to have 2 players");




    }

    @Test
    public void testBoard() {
        Board b = new Board(3);
        int rowSize = b.getCells().size();
        assertEquals(3, rowSize, "if constructor of board with size n is called" +
                "n rows must be created");

        int colSize = b.getCells().get(0).size();
        assertEquals(3, colSize, "if constructor of board with size n is called" +
                "n col must be created");

    }

}
