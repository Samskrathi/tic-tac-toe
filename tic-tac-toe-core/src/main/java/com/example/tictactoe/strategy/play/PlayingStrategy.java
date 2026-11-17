package com.example.tictactoe.strategy.play;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;

public interface PlayingStrategy {

    public BoardCell makeMove(Board board);
}
