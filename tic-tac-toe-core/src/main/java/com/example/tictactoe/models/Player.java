package com.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Player {

    private Symbol symbol;

    public abstract BoardCell makeMove(Board board);


}
