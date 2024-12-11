package com.chess.Controller;

import com.chess.POJO.Chess;

public class King extends Chess {

    public King(Color color, String name, int xpos, int ypos, String imgPath) {
        super(color, name, xpos, ypos, imgPath);
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
        int dx = Math.abs(newX - getXpos());
        int dy = Math.abs(newY - getYpos());

        if (dx > 1 || dy > 1) {
            return false;
        }

        Chess targetPiece = board[newX][newY];

        if (targetPiece != null && targetPiece.getColor() == getColor()) {
            return false;
        }

        return true;
    }

}
