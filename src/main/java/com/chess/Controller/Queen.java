package com.chess.Controller;

import com.chess.POJO.Chess;

public class Queen extends Chess {

    public Queen(Color color, String name, int xpos, int ypos, String imgPath) {
        super(color, name, xpos, ypos, imgPath);
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
        int dx = Math.abs(newX - getXpos());
        int dy = Math.abs(newY - getYpos());

        if (dx == dy || newX == getXpos() || newY == getYpos()) {

            if (newX == getXpos()) {
                int step = (newY > getYpos()) ? 1 : -1;
                for (int y = getYpos() + step; y != newY; y += step) {
                    if (board[getXpos()][y] != null) {
                        return false;
                    }
                }
            } else if (newY == getYpos()) {
                int step = (newX > getXpos()) ? 1 : -1;
                for (int x = getXpos() + step; x != newX; x += step) {
                    if (board[x][getYpos()] != null) {
                        return false;
                    }
                }
            } else if (dx == dy) {
                int stepX = (newX > getXpos()) ? 1 : -1;
                int stepY = (newY > getYpos()) ? 1 : -1;
                int x = getXpos() + stepX;
                int y = getYpos() + stepY;
                while (x != newX && y != newY) {
                    if (board[x][y] != null) {
                        return false;
                    }
                    x += stepX;
                    y += stepY;
                }
            }

            Chess targetPiece = board[newX][newY];
            return targetPiece == null || targetPiece.getColor() != getColor();
        }

        return false;
    }

}
