package org.example;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        if (dx != dy) {
            return false;
        }
        int xDirection = startX < endX ? 1 : -1;
        int yDirection = startY < endY ? 1 : -1;
        for (int i = 1; i < dx; i++) {
            if (board[startX + i * xDirection][startY + i * yDirection] != null) {
                return false;
            }
        }
        return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite();
    }
}
