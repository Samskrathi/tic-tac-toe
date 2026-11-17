package com.example.tictactoe.exception;

public class InValidPlayersException extends RuntimeException {
    public InValidPlayersException(String message) {
        super("Invalid list of players");
    }
}
