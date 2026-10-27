package com.example.tictactoe.cli;

import com.example.tictactoe.core.GameStatus;
import com.example.tictactoe.core.Player;
import com.example.tictactoe.core.TicTacToeGame;

import java.io.PrintStream;
import java.util.Scanner;

public final class TicTacToeApplication {
    private TicTacToeApplication() {
    }

    public static void main(String[] args) {
        run(new Scanner(System.in), System.out);
    }

    static GameStatus run(Scanner input, PrintStream output) {
        TicTacToeGame game = new TicTacToeGame();
        output.println("Tic-Tac-Toe: enter row and column from 1 to 3 (for example: 2 3).");

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            printBoard(game, output);
            output.printf("Player %s, move: ", game.getCurrentPlayer());
            if (!input.hasNextLine()) {
                output.println();
                break;
            }

            String[] coordinates = input.nextLine().trim().split("\\s+");
            if (coordinates.length != 2) {
                output.println("Enter a row and a column.");
                continue;
            }

            try {
                int row = Integer.parseInt(coordinates[0]) - 1;
                int column = Integer.parseInt(coordinates[1]) - 1;
                game.play(row, column);
            } catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
                output.println("Invalid move. Choose an empty cell using values from 1 to 3.");
            }
        }

        printBoard(game, output);
        if (game.getStatus() == GameStatus.DRAW) {
            output.println("It's a draw.");
        } else if (game.getStatus() == GameStatus.X_WON || game.getStatus() == GameStatus.O_WON) {
            Player winner = game.getStatus() == GameStatus.X_WON ? Player.X : Player.O;
            output.printf("Player %s wins.%n", winner);
        }
        return game.getStatus();
    }

    private static void printBoard(TicTacToeGame game, PrintStream output) {
        output.println("  1 2 3");
        for (int row = 0; row < 3; row++) {
            output.print(row + 1);
            for (int column = 0; column < 3; column++) {
                Player cell = game.getCell(row, column);
                output.print(" " + (cell == null ? "-" : cell));
            }
            output.println();
        }
    }
}