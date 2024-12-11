package com.chess.Controller;

import com.chess.POJO.Chess;

public class Bishop extends Chess {

    public Bishop(Color color, String name, int xpos, int ypos, String imgPath) {
        super(color, name, xpos, ypos, imgPath);
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
        int dx = Math.abs(newX - getXpos());
        int dy = Math.abs(newY - getYpos());
        if (dx != dy) {
            return false;
        }

        int xStep = (newX > getXpos()) ? 1 : -1;
        int yStep = (newY > getYpos()) ? 1 : -1;

        int x = getXpos() + xStep;
        int y = getYpos() + yStep;
        while (x != newX && y != newY) {
            if (board[x][y] != null) {
                return false;
            }
            x += xStep;
            y += yStep;
        }

        Chess targetPiece = board[newX][newY];
        return targetPiece == null || targetPiece.getColor() != getColor();
    }

}
