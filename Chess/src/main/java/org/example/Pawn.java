package org.example;

public class Pawn extends ChessPiece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int direction = isWhite() ? -1 : 1;
        if (startX + direction == endX && startY == endY && board[endX][endY] == null) {
            return true; // Move forward
        }
        if (startX + direction == endX && Math.abs(startY - endY) == 1 && board[endX][endY] != null && board[endX][endY].isWhite() != isWhite()) {
            return true; // Capture
        }
        return false;
    }
}
