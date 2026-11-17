package com.example.tictactoe.strategy.play.win;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;
import com.example.tictactoe.models.Symbol;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinner(Board board, BoardCell move) {
        int row = move.getRow();
        for (int col = 0; col < board.getSize(); col++) {
            Symbol symbol = board.getCells()
                    .get(row)
                    .get(col)
                    .getSymbol();

            if (!move.getSymbol().equals(symbol)) {
                return false;
            }
        }
        return true;
    }
}
