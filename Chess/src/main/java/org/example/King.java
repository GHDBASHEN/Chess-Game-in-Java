package org.example;

public class King extends ChessPiece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        return dx <= 1 && dy <= 1 && (board[endX][endY] == null || board[endX][endY].isWhite() != isWhite());
    }
}

