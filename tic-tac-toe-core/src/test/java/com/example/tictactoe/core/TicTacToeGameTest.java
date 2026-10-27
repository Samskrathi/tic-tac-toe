package com.example.tictactoe.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeGameTest {
    @Test
    void detectsRowWinAndPreventsFurtherMoves() {
        TicTacToeGame game = new TicTacToeGame();
        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        Move winningMove = game.play(0, 2);

        assertEquals(Player.X, winningMove.getPlayer());
        assertEquals(GameStatus.X_WON, game.getStatus());
        assertThrows(IllegalStateException.class, () -> game.play(2, 2));
    }

    @Test
    void rejectsOccupiedAndOutOfBoundsCells() {
        TicTacToeGame game = new TicTacToeGame();
        game.play(1, 1);

        assertThrows(IllegalArgumentException.class, () -> game.play(1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> game.play(3, 0));
    }

    @Test
    void detectsDraw() {
        TicTacToeGame game = new TicTacToeGame();
        int[][] moves = {
                {0, 0}, {0, 1}, {0, 2},
                {1, 1}, {1, 0}, {1, 2},
                {2, 1}, {2, 0}, {2, 2}
        };

        for (int[] move : moves) {
            game.play(move[0], move[1]);
        }

        assertEquals(GameStatus.DRAW, game.getStatus());
    }
}