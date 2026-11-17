package com.example.tictactoe;


import com.example.tictactoe.exception.InvalidSymbolException;
import com.example.tictactoe.models.*;
import com.example.tictactoe.strategy.play.RandomPlayingStrategy;
import com.example.tictactoe.strategy.play.win.ColumnWinningStrategy;
import com.example.tictactoe.strategy.play.win.DiagonalWinningStrategy;
import com.example.tictactoe.strategy.play.win.RowWinningStrategy;

import java.util.Scanner;

//client code
public class TicTacToe {

    private static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        //ask for user input
        System.out.println("Welcome to Tic-Tac-Toe!");
        HumanPlayer humanPlayer = getUserInput();

        Game game = createGame(humanPlayer);
        game.start();
        game.getBoard().printBoard();


        while(game.getStatus() == GameStatus.IN_PROGRESS) {
            Player player = game.getNextPlayer();
            System.out.println("next player is "+ player.getSymbol());
            game.makeMove();
            game.getBoard().printBoard();
        }

        if(game.getStatus() == GameStatus.FINISHED) {
            System.out.println("Game is over and Player "+ game.getWinner().getSymbol() + " won!!");

        }

        if(game.getStatus() == GameStatus.DRAW) {
            System.out.println("Game is over!! try again...");

        }




        //create a game


        //start a game
        //assign the first game
        //mark game in progress
    }

    private static Game createGame(HumanPlayer humanPlayer) {

        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        new BotPlayer(decideBotPlayerSymbol(humanPlayer.getSymbol()), Level.EASY, new RandomPlayingStrategy())
                )
                .withWinningStrategy(new RowWinningStrategy())
                .withWinningStrategy(new ColumnWinningStrategy())
                .build();

    }

    private static Symbol decideBotPlayerSymbol(Symbol symbol) {
        if(symbol == Symbol.O) {
            return Symbol.X;
        }
        return Symbol.O;
    }

    private static HumanPlayer getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter symbol: [X or O]");
        Symbol symbol;
        try{
            symbol =  Symbol.valueOf(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            throw new InvalidSymbolException();

        }

        User user = new User(name, email, null);
        return new HumanPlayer(symbol, user);
    }
}
