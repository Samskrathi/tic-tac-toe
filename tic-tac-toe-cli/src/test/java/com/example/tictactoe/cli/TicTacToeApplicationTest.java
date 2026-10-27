package com.example.tictactoe.cli;

import com.example.tictactoe.core.GameStatus;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeApplicationTest {
    @Test
    void playsThroughAWinAndPrintsTheResult() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        GameStatus status = TicTacToeApplication.run(
                new Scanner("1 1\n2 1\n1 2\n2 2\n1 3\n"),
                new PrintStream(output, true, StandardCharsets.UTF_8));

        assertEquals(GameStatus.X_WON, status);
        assertTrue(output.toString(StandardCharsets.UTF_8).contains("Player X wins."));
    }
}