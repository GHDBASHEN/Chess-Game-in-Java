package org.example;

public class Rook extends ChessPiece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        if (startX != endX && startY != endY) {
            return false;
        }
        // Check if the path is clear
        if (startX == endX) {
            int direction = startY < endY ? 1 : -1;
            for (int y = startY + direction; y != endY; y += direction) {
                if (board[startX][y] != null) {
                    return false;
                }
            }
        } else {
            int direction = startX < endX ? 1 : -1;
            for (int x = startX + direction; x != endX; x += direction) {
                if (board[x][startY] != null) {
                    return false;
                }
            }
        }
        return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite();
    }
}
