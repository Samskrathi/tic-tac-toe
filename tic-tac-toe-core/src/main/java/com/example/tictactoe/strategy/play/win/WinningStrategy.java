package com.example.tictactoe.strategy.play.win;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;

public interface WinningStrategy {

    public boolean isWinner(Board board, BoardCell move);
}
