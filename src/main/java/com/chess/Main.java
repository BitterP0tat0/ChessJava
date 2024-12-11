package com.chess;

import javax.swing.SwingUtilities;

import com.chess.Interface.ChessGUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGUI gui = new ChessGUI();
            gui.setVisible(true);
        });
    }
}
