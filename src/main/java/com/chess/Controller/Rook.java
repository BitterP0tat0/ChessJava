package com.chess.Controller;

import com.chess.POJO.Chess;

public class Rook extends Chess {

    public Rook(Color color, String name, int xpos, int ypos, String imgPath) {
        super(color, name, xpos, ypos, imgPath);
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
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
        } else {
            return false;
        }

        // 检查目标位置是否为空或有敌方棋子
        Chess targetPiece = board[newX][newY];
        return targetPiece == null || targetPiece.getColor() != getColor();
    }

}
