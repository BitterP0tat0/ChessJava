package com.chess.POJO;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Chess> Black;
    private List<Chess> White;

    public Player() {
        Black = new ArrayList<>();
        Black.add(new Chess(Chess.Color.black, "Bishop", 2, 0, "img/chesses/black-bishop.png"));
        Black.add(new Chess(Chess.Color.black, "King", 4, 0, "img/chesses/black-king.png"));
        Black.add(new Chess(Chess.Color.black, "Knight", 1, 0, "img/chesses/black-knight.png"));
        Black.add(new Chess(Chess.Color.black, "Queen", 3, 0, "img/chesses/black-queen.png"));
        Black.add(new Chess(Chess.Color.black, "Rook", 0, 0, "img/chesses/black-rook.png"));
        Black.add(new Chess(Chess.Color.black, "Rook", 7, 0, "img/chesses/black-rook.png"));
        Black.add(new Chess(Chess.Color.black, "Bishop", 5, 0, "img/chesses/black-bishop.png"));
        Black.add(new Chess(Chess.Color.black, "Knight", 6, 0, "img/chesses/black-knight.png"));

        for (int i = 0; i < 8; i++) {
            Black.add(new Chess(Chess.Color.black, "Pawn", i, 1, "img/chesses/black-pawn.png"));
        }

        White = new ArrayList<>();
        White.add(new Chess(Chess.Color.white, "Bishop", 2, 7, "img/chesses/white-bishop.png"));
        White.add(new Chess(Chess.Color.white, "King", 4, 7, "img/chesses/white-king.png"));
        White.add(new Chess(Chess.Color.white, "Knight", 1, 7, "img/chesses/white-knight.png"));
        White.add(new Chess(Chess.Color.white, "Queen", 3, 7, "img/chesses/white-queen.png"));
        White.add(new Chess(Chess.Color.white, "Rook", 0, 7, "img/chesses/white-rook.png"));
        White.add(new Chess(Chess.Color.white, "Rook", 7, 7, "img/chesses/white-rook.png"));
        White.add(new Chess(Chess.Color.white, "Bishop", 5, 7, "img/chesses/white-bishop.png"));
        White.add(new Chess(Chess.Color.white, "Knight", 6, 7, "img/chesses/white-knight.png"));

        for (int i = 0; i < 8; i++) {
            White.add(new Chess(Chess.Color.white, "Pawn", i, 6, "img/chesses/white-pawn.png"));
        }
    }

    public List<Chess> getBlack() {
        return Black;
    }

    public List<Chess> getWhite() {
        return White;
    }

    public void setBlack(List<Chess> black) {
        Black = black;
    }

    public void setWhite(List<Chess> white) {
        White = white;
    }

    @Override
    public String toString() {
        return "Player [Black=" + Black + ", White=" + White + "]";
    }
}
