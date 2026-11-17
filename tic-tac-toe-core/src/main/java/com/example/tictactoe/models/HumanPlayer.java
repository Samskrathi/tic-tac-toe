package com.example.tictactoe.models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private User user;
    private Scanner scanner =  new Scanner(System.in);

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;

    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column: ");
        int row =  scanner.nextInt();
        int column =  scanner.nextInt();
        return new BoardCell(row, column, getSymbol());
    }
}
