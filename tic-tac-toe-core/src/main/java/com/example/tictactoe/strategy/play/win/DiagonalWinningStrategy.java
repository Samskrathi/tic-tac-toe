package com.example.tictactoe.strategy.play.win;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean isWinner(Board board, BoardCell move) {
        int row = move.getRow();
        int col = move.getCol();
        int size = board.getSize();

        boolean primaryDiagonal = true;
        boolean secondaryDiagonal = true;

        // Check primary diagonal (\)
        if (row == col) {
            for (int i = 0; i < size; i++) {
                if (!board.getCells().get(i).get(i)
                        .getSymbol().equals(move.getSymbol())) {
                    primaryDiagonal = false;
                    break;
                }
            }

            if (primaryDiagonal) {
                return true;
            }
        }

        // Check secondary diagonal (/)
        if (row + col == size - 1) {
            for (int i = 0; i < size; i++) {
                if (!board.getCells().get(i).get(size - 1 - i)
                        .getSymbol().equals(move.getSymbol())) {
                    secondaryDiagonal = false;
                    break;
                }
            }

            if (secondaryDiagonal) {
                return true;
            }
        }

        return false;
    }

}
