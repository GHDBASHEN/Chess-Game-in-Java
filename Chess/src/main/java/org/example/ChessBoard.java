package org.example;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        setupBoard();
    }

    private void setupBoard() {
        // Setup Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false);
            board[6][i] = new Pawn(true);
        }

        // Setup Rooks
        board[0][0] = new Rook(false);
        board[0][7] = new Rook(false);
        board[7][0] = new Rook(true);
        board[7][7] = new Rook(true);

        // Setup Knights
        board[0][1] = new Knight(false);
        board[0][6] = new Knight(false);
        board[7][1] = new Knight(true);
        board[7][6] = new Knight(true);

        // Setup Bishops
        board[0][2] = new Bishop(false);
        board[0][5] = new Bishop(false);
        board[7][2] = new Bishop(true);
        board[7][5] = new Bishop(true);

        // Setup Queens
        board[0][3] = new Queen(false);
        board[7][3] = new Queen(true);

        // Setup Kings
        board[0][4] = new King(false);
        board[7][4] = new King(true);
    }

    public ChessPiece getPiece(int x, int y) {
        return board[x][y];
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        if (board[startX][startY] != null && board[startX][startY].isValidMove(startX, startY, endX, endY, board)) {
            board[endX][endY] = board[startX][startY];
            board[startX][startY] = null;
            return true;
        }
        return false;
    }
}

