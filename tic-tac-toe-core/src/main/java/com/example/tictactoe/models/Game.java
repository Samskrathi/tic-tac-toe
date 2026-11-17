package com.example.tictactoe.models;

import com.example.tictactoe.exception.InValidMoveException;
import com.example.tictactoe.exception.InValidPlayersException;
import com.example.tictactoe.strategy.play.win.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Game {

    private Board board;

    private List<Player> players = new ArrayList<>();

    private int nextPlayerIndex = 0;

    private GameStatus status;

    private List<WinningStrategy> winningStrategy = new ArrayList<>();

    private Player winner;

    private Game() {

    }


    public void start() {
        Random random = new Random();
        nextPlayerIndex = random.nextInt(players.size());
        status = GameStatus.IN_PROGRESS;


    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public void makeMove(){

        //get next player and move from the player
        BoardCell cell = getNextMove();

        //validate user move --if cell already filled or not
        isValidMove(cell);

        //update board
        board.updateBoard(cell);

        //check win
        if(checkWinner(board, cell)) {
            status = GameStatus.FINISHED;
            winner = getNextPlayer();

        }

        // or draw
        if(checkDraw(board)) {
            status = GameStatus.DRAW;
        }

        //update next player
        nextPlayerIndex = (nextPlayerIndex+1) % players.size();
    }

    private BoardCell getNextMove(){
        Player player = players.get(nextPlayerIndex);

        return player.makeMove(board);
    }

    private boolean isValidMove(BoardCell cell){
        if(!board.isEmpty(cell.getRow(), cell.getCol())) {
            throw new InValidMoveException(cell.getRow(), cell.getCol());
        }
        return true;
    }



    public static Builder builder() {
        return new Builder();
    }

    private boolean checkWinner(Board board, BoardCell cell) {
       for(WinningStrategy winningStrategy : winningStrategy) {
           if(winningStrategy.isWinner(board, cell)) {
               return true;
           }
       }
       return false;
    }

    private boolean checkDraw(Board board) {

        return board.getCells().stream()
                .flatMap(Collection::stream)
                .allMatch(cell -> cell.getSymbol() != null);

    }

    public static class Builder {

        private static final int PLAYER_SIZE = 2;
        private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;

        private Game game;

        private Builder() {
            game = new Game();

        }

        public Builder withSize(int size) {
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            this.game.getPlayers().add(player);
            return this;
        }

        public Builder withWinningStrategy(WinningStrategy strategy) {
            this.game.getWinningStrategy().add(strategy);
            return this;
        }

        public Game build() {
            boolean isValid = validate();
            if(!isValid) {
                throw new InValidPlayersException("Invalid player count");
            }

            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.status = DEFAULT_STATUS;
            newGame.winningStrategy = game.getWinningStrategy();

            return newGame;

        }

        public boolean validate() {
            if(game.players.size() != PLAYER_SIZE) {
                return false;

            }

            Set<Symbol> symbols = game.players.stream().map(Player::getSymbol).collect(Collectors.toSet());

            return symbols.size() == PLAYER_SIZE;
        }

    }

}
