package com.chess.POJO;

public class Chess {
    private Color color;
    private String name;
    private int xpos;
    private int ypos;
    private String imgPath;

    public Chess(Color color, String name, int xpos, int ypos, String imgPath) {
        this.color = color;
        this.name = name;
        this.xpos = xpos;
        this.ypos = ypos;
        this.imgPath = imgPath;
    }

    public enum Color {
        white, black;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Chess [color=" + color + ", name=" + name + ", xpos=" + xpos + ", ypos=" + ypos + ", imgPath=" + imgPath
                + "]";
    }

    public boolean isValidMove(int newX, int newY, Chess[][] board) {
        return false;
    }
}
