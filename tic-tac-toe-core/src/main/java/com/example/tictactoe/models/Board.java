package com.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {

    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initialiseCells(size);
    }

    private List<List<BoardCell>> initialiseCells(int size) {
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int col) {
        return cells.get(row).get(col).getSymbol() == null;

    }

    public void updateBoard(BoardCell cell) {
        cells.get(cell.getRow()).get(cell.getCol()).setSymbol(cell.getSymbol());
    }

    public void printBoard() {
            for (int i = 0; i < cells.size(); ++i) {
                for (int j = 0; j < cells.size(); ++j) {
                    Symbol symbol = cells.get(i).get(j).getSymbol();

                    if (symbol == null) {
                        System.out.printf(" | - | ");
                    } else {
                        System.out.printf(" | " + symbol + " | ");
                    }
                }
                System.out.printf("\n");
            }

    }

    public List<BoardCell> getAvailableCells() {
        return cells.stream().flatMap(List::stream)
                .filter(cell ->cell.getSymbol() == null)
                .toList();
    }

}
