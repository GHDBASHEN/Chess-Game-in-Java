package org.example;

public class Knight extends ChessPiece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite();
        }
        return false;
    }
}

