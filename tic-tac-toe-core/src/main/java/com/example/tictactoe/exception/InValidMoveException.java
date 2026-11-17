package com.example.tictactoe.exception;

public class InValidMoveException extends RuntimeException {
    public InValidMoveException(int row, int col) {
        super("Invalid move with row " + row + " and column " + col);
    }
}
