package com.example.tictactoe.models;

import com.example.tictactoe.strategy.play.PlayingStrategy;

public class BotPlayer extends Player{

    private Level level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(Symbol symbol, Level level, PlayingStrategy playingStrategy) {
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makeMove(Board board) {
        BoardCell cell = playingStrategy.makeMove(board);
        cell.setSymbol(getSymbol());
        return cell;


    }
}
