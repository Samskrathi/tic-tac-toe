package com.example.tictactoe.core;

public enum Player {
    X,
    O;

    public Player opponent() {
        return this == X ? O : X;
    }
}