package com.example.tictactoe.strategy.play;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.BoardCell;

import java.util.List;
import java.util.Random;

public class RandomPlayingStrategy implements PlayingStrategy {

    @Override
    public BoardCell makeMove(Board board) {

        //OUTPUT - A Cell from list of available cell
        //get a list if empty cell
        List<BoardCell> cells = board.getAvailableCells();

        Random random = new Random();
        int randomIndex = random.nextInt(cells.size());

        BoardCell cell = cells.get(randomIndex);

        return new BoardCell(cell.getRow(),  cell.getCol());
    }
}
