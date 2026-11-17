package com.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCell {

    private int row;
    private int col;

    private Symbol symbol;
    public BoardCell(int row, int column) {
        this.row = row;
        this.col = column;
    }

}
