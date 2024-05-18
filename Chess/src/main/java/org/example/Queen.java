package org.example;

public class Queen extends ChessPiece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        Rook rook = new Rook(isWhite());
        Bishop bishop = new Bishop(isWhite());
        return rook.isValidMove(startX, startY, endX, endY, board) || bishop.isValidMove(startX, startY, endX, endY, board);
    }
}
