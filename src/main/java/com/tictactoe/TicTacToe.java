package com.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private Board board;
    private Player currentPlayer;
    private int moves;

    @Override
    public void start(Stage primaryStage) {
        board = new Board();
        currentPlayer = Player.X;
        moves = 0;

        GridPane gridPane = new GridPane();
        primaryStage.setTitle("Tic Tac Toe");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                int row = i;
                int col = j;
                button.setOnAction(event -> {
                    if (!board.isEmpity(row, col) || board.isGameOver())
                        return;

                    board.mark(row, col, currentPlayer);
                    button.setText(currentPlayer.toString());
                    moves++;
                    if (board.checkForWin()) {
                        System.out.println(currentPlayer + " wins!");
                        disableAllButtons(gridPane);
                    } else if (moves == 9) {
                        System.out.println("It's a draw!");
                    } else {
                        currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
                    }
                });
                gridPane.add(button, j, i);
            }
        }

        Button restartButton = new Button("Restart");
        restartButton.setOnAction(event -> restart(primaryStage, gridPane));

        HBox hbox = new HBox(restartButton);
        hbox.setLayoutX(100);
        hbox.setLayoutY(320);

        Scene scene = new Scene(new javafx.scene.layout.Pane(gridPane, hbox), 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void disableAllButtons(GridPane gridPane) {
        for (javafx.scene.Node node : gridPane.getChildren()) {
            Button button = (Button) node;
            button.setDisable(true);
        }
    }

    private void restart(Stage primaryStage, GridPane gridPane) {
        for (javafx.scene.Node node : gridPane.getChildren()) {
            Button button = (Button) node;
            button.setText("");
            button.setDisable(false);
        }
        board = new Board();
        currentPlayer = Player.X;
        moves = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
