package com.chess.Controller;

import com.chess.POJO.Chess;

public class Pawn extends Chess {

    public Pawn(Color color, String name, int xpos, int ypos, String imgPath) {
        super(color, name, xpos, ypos, imgPath);
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
        int direction = (getColor() == Color.white) ? -1 : 1;

        if ((getXpos() == 1 && getColor() == Color.white) || (getXpos() == 6 && getColor() == Color.black)) {
            if (newX == getXpos() + direction && newY == getYpos()) {
                return board[newX][newY] == null;
            }
            if (newX == getXpos() + 2 * direction && newY == getYpos() &&
                    board[getXpos() + direction][getYpos()] == null) {
                return board[newX][newY] == null;
            }
        }

        if (newX == getXpos() + direction && Math.abs(newY - getYpos()) == 1) {
            return board[newX][newY] != null && board[newX][newY].getColor() != getColor(); // 吃掉敌方棋子
        }

        return false;
    }

    public boolean canPromote() {
        return (getColor() == Color.white && getXpos() == 0) || (getColor() == Color.black && getXpos() == 7);
    }
}
