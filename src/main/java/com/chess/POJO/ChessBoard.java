package com.chess.POJO;

public class ChessBoard {
    private Chess[][] board;

    public ChessBoard() {
        board = new Chess[8][8];

        board[0][0] = new Chess(Chess.Color.black, "Rook", 0, 0, "img/chesses/black-rook.png");
        board[0][1] = new Chess(Chess.Color.black, "Knight", 1, 0, "img/chesses/black-knight.png");
        board[0][2] = new Chess(Chess.Color.black, "Bishop", 2, 0, "img/chesses/black-bishop.png");
        board[0][3] = new Chess(Chess.Color.black, "Queen", 3, 0, "img/chesses/black-queen.png");
        board[0][4] = new Chess(Chess.Color.black, "King", 4, 0, "img/chesses/black-king.png");
        board[0][5] = new Chess(Chess.Color.black, "Bishop", 5, 0, "img/chesses/black-bishop.png");
        board[0][6] = new Chess(Chess.Color.black, "Knight", 6, 0, "img/chesses/black-knight.png");
        board[0][7] = new Chess(Chess.Color.black, "Rook", 7, 0, "img/chesses/black-rook.png");

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Chess(Chess.Color.black, "Pawn", i, 1, "img/chesses/black-pawn.png");
        }

        board[7][0] = new Chess(Chess.Color.white, "Rook", 0, 7, "img/chesses/white-rook.png");
        board[7][1] = new Chess(Chess.Color.white, "Knight", 1, 7, "img/chesses/white-knight.png");
        board[7][2] = new Chess(Chess.Color.white, "Bishop", 2, 7, "img/chesses/white-bishop.png");
        board[7][3] = new Chess(Chess.Color.white, "Queen", 3, 7, "img/chesses/white-queen.png");
        board[7][4] = new Chess(Chess.Color.white, "King", 4, 7, "img/chesses/white-king.png");
        board[7][5] = new Chess(Chess.Color.white, "Bishop", 5, 7, "img/chesses/white-bishop.png");
        board[7][6] = new Chess(Chess.Color.white, "Knight", 6, 7, "img/chesses/white-knight.png");
        board[7][7] = new Chess(Chess.Color.white, "Rook", 7, 7, "img/chesses/white-rook.png");

        for (int i = 0; i < 8; i++) {
            board[6][i] = new Chess(Chess.Color.white, "Pawn", i, 6, "img/chesses/white-pawn.png");
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
    }

    public Chess[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getName().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
