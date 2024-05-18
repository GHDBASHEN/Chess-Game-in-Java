package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessApp extends Application {
    private ChessBoard chessBoard;
    private GridPane gridPane;
    private boolean pieceSelected = false;
    private int selectedX, selectedY;

    @Override
    public void start(Stage primaryStage) {
        chessBoard = new ChessBoard();
        gridPane = new GridPane();

        initializeGrid();
        updateGrid();

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = new Button();
                button.setPrefSize(75, 75);
                button.setStyle((i + j) % 2 == 0 ? "-fx-background-color: white;" : "-fx-background-color: gray;");

                int finalI = i;
                int finalJ = j;
                button.setOnAction(e -> handleMove(finalI, finalJ));

                gridPane.add(button, j, i);
            }
        }
    }

    private void handleMove(int x, int y) {
        if (!pieceSelected) {
            if (chessBoard.getPiece(x, y) != null) {
                pieceSelected = true;
                selectedX = x;
                selectedY = y;
            }
        } else {
            if (chessBoard.movePiece(selectedX, selectedY, x, y)) {
                updateGrid();
            }
            pieceSelected = false;
        }
    }

    private void updateGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button button = (Button) gridPane.getChildren().get(i * 8 + j);
                ChessPiece piece = chessBoard.getPiece(i, j);
                if (piece != null) {
                    button.setText(piece.getClass().getSimpleName().substring(0, 2)); // Example: "Pa" for Pawn
                } else {
                    button.setText("");
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
