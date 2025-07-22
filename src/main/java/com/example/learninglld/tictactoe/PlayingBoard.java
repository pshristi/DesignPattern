package com.example.learninglld.tictactoe;

public class PlayingBoard {
    public PlayingPiece[][] board;
    public int size;

    PlayingBoard(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    boolean fillPosition(Integer x, Integer y, PlayingPiece piece) {
        if(board[x][y] == null) {
            board[x][y] = piece;
            return false;
        }
        else {
            return true;
        }
    }
}
