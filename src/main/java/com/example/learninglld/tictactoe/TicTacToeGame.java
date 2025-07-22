package com.example.learninglld.tictactoe;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private PlayingBoard board;
    private Deque<Player> players;

    TicTacToeGame(){
        this.init();
    }

    private void init() {
        PlayingBoard board = new PlayingBoard(3);
        this.board = board;
        Player player1 = new Player("Player1", new PlayingPieceX());
        Player player2 = new Player("Player2", new PlayingPieceO());
        players.add(player1);
        players.add(player2);
    }

    public String playGame() {

        boolean noWinner = true;
        while(noWinner) {
            //Get player
            Player player = players.removeFirst();
            //Check if all cells are filled
            //get the free space from the board
            /*board.printBoard();
            List<Pair<Integer, Integer>> freeSpaces =  board.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

             */

            //Ask for position to fill
            System.out.println("Fill your position "+ player.getName());
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            Integer x = Integer.valueOf(values[0]);
            Integer y = Integer.valueOf(values[1]);

            //Fill position
            boolean isAlreadyFilled = board.fillPosition(x, y, player.getPlayingPiece());
            if(isAlreadyFilled) {
                System.out.println("Already filled, please try again");
                players.addFirst(player);
                continue;
            }
            players.addLast(player);

            //If filled correctly, check if winner
            boolean isWinner = this.checkForWinner(x, y, player.getPlayingPiece().piece);
            if(isWinner) {
                return player.getName();
            }
        }
        return "No winner";
    }

    public boolean checkForWinner(int row, int column, PlayingPieces pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.size;i++) {

            if(board.board[row][i] == null || board.board[row][i].piece != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.size;i++) {

            if(board.board[i][column] == null || board.board[i][column].piece != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].piece != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].piece != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
