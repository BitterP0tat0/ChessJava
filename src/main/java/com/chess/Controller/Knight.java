package com.chess.Controller;

import com.chess.POJO.Chess;

public class Knight extends Chess {

    public Knight(Color color, String name, int xpos, int ypos, String imgPath) {
        super(color, name, xpos, ypos, imgPath);
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
        int dx = Math.abs(newX - getXpos());
        int dy = Math.abs(newY - getYpos());

        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            Chess targetPiece = board[newX][newY];

            return targetPiece == null || targetPiece.getColor() != getColor();
        }

        return false;
    }
}