package com.example.tictactoe.strategy.play.win;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;
import com.example.tictactoe.models.Symbol;

public class ColumnWinningStrategy implements WinningStrategy{

    @Override
    public boolean isWinner(Board board, BoardCell move) {
        int col = move.getCol();

        if (move.getSymbol() == null) {
            return false;
        }

        for (int row = 0; row < board.getSize(); row++) {
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
