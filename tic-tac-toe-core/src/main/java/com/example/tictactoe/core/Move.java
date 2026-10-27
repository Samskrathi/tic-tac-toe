package com.example.tictactoe.core;

import lombok.Value;

@Value
public class Move {
    int row;
    int column;
    Player player;
}