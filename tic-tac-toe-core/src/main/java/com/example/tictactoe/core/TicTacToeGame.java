package com.example.tictactoe.core;

public final class TicTacToeGame {
    private final Player[][] board = new Player[3][3];
    private Player currentPlayer = Player.X;
    private GameStatus status = GameStatus.IN_PROGRESS;

    public Move play(int row, int column) {
        if (status != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("The game is already over.");
        }
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            throw new IndexOutOfBoundsException("Row and column must be between 0 and 2.");
        }
        if (board[row][column] != null) {
            throw new IllegalArgumentException("That cell is already occupied.");
        }

        Move move = new Move(row, column, currentPlayer);
        board[row][column] = currentPlayer;
        if (hasWon(currentPlayer)) {
            status = currentPlayer == Player.X ? GameStatus.X_WON : GameStatus.O_WON;
        } else if (isBoardFull()) {
            status = GameStatus.DRAW;
        } else {
            currentPlayer = currentPlayer.opponent();
        }
        return move;
    }

    public Player getCell(int row, int column) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            throw new IndexOutOfBoundsException("Row and column must be between 0 and 2.");
        }
        return board[row][column];
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getStatus() {
        return status;
    }

    private boolean hasWon(Player player) {
        for (int index = 0; index < 3; index++) {
            if ((board[index][0] == player && board[index][1] == player && board[index][2] == player)
                    || (board[0][index] == player && board[1][index] == player && board[2][index] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        for (Player[] row : board) {
            for (Player cell : row) {
                if (cell == null) {
                    return false;
                }
            }
        }
        return true;
    }
}