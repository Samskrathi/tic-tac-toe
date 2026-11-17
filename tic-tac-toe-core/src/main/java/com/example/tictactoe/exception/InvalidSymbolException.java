package com.example.tictactoe.exception;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("You have entered invalid symbol. use O or X");
    }
}
