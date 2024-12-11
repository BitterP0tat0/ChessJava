package com.chess.Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.chess.Controller.Bishop;
import com.chess.Controller.King;
import com.chess.Controller.Knight;
import com.chess.Controller.Pawn;
import com.chess.Controller.Queen;
import com.chess.Controller.Rook;
import com.chess.POJO.Chess;
import com.chess.POJO.ChessBoard;

public class ChessGUI extends JFrame {

    private ChessBoard chessBoard;
    private static final int BOARD_SIZE = 8;
    private int selectedRow = -1;
    private int selectedCol = -1;
    private boolean whiteTurn = true;

    public ChessGUI() {
        setTitle("Chess Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        chessBoard = new ChessBoard();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMouseClick(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int tileSize = Math.min(getWidth(), getHeight()) / BOARD_SIZE;
        drawChessBoard(g, tileSize);
        drawChessPieces(g, tileSize);
    }

    private void drawChessBoard(Graphics g, int tileSize) {
        int verticalOffset = 15;
        g.translate((getWidth() - tileSize * BOARD_SIZE) / 2,
                (getHeight() - tileSize * BOARD_SIZE) / 2 + verticalOffset);
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);

                if (selectedRow == row && selectedCol == col) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                }
            }
        }
    }

    private void drawChessPieces(Graphics g, int tileSize) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Chess piece = chessBoard.getBoard()[row][col];
                if (piece != null) {
                    String imgPath = piece.getImgPath();
                    ImageIcon icon = new ImageIcon(getClass().getResource("/" + imgPath));
                    Image img = icon.getImage();
                    g.drawImage(img, col * tileSize, row * tileSize, tileSize, tileSize, this);
                }
            }
        }
    }

    private void handleMouseClick(MouseEvent e) {
        int tileSize = Math.min(getWidth(), getHeight()) / BOARD_SIZE;
        int x = e.getX() - (getWidth() - tileSize * BOARD_SIZE) / 2;
        int y = e.getY() - (getHeight() - tileSize * BOARD_SIZE) / 2;

        int row = y / tileSize;
        int col = x / tileSize;

        if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE) {
            Chess targetPiece = chessBoard.getBoard()[row][col];

            if (selectedRow == -1 && selectedCol == -1) {
                if (targetPiece != null
                        && targetPiece.getColor() == (whiteTurn ? Chess.Color.white : Chess.Color.black)) {
                    selectedRow = row;
                    selectedCol = col;
                    repaint();
                }
            } else {
                Chess selectedPiece = chessBoard.getBoard()[selectedRow][selectedCol];

                if (targetPiece == null || targetPiece.getColor() != selectedPiece.getColor()) {
                    if (isMoveValid(selectedPiece, row, col)) {
                        chessBoard.getBoard()[row][col] = selectedPiece;
                        chessBoard.getBoard()[selectedRow][selectedCol] = null;
                        whiteTurn = !whiteTurn;
                        selectedRow = -1;
                        selectedCol = -1;
                        repaint();
                    }
                } else {
                    selectedRow = row;
                    selectedCol = col;
                    repaint();
                }
            }
        }
    }

    private boolean isMoveValid(Chess piece, int newRow, int newCol) {
        if (piece == null) {
            return false;
        }

        if (piece instanceof Knight) {
            Knight knight = (Knight) piece;
            return knight.isValidMove(newRow, newCol, chessBoard.getBoard());
        } else if (piece instanceof Rook) {
            Rook rook = (Rook) piece;
            return rook.isValidMove(newRow, newCol, chessBoard.getBoard());
        } else if (piece instanceof Bishop) {
            Bishop bishop = (Bishop) piece;
            return bishop.isValidMove(newRow, newCol, chessBoard.getBoard());
        } else if (piece instanceof Queen) {
            Queen queen = (Queen) piece;
            return queen.isValidMove(newRow, newCol, chessBoard.getBoard());
        } else if (piece instanceof King) {
            King king = (King) piece;
            return king.isValidMove(newRow, newCol, chessBoard.getBoard());
        } else if (piece instanceof Pawn) {
            Pawn pawn = (Pawn) piece;
            return pawn.isValidMove(newRow, newCol, chessBoard.getBoard());
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGUI gui = new ChessGUI();
            gui.setVisible(true);
        });
    }
}