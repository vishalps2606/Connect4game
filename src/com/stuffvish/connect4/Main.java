package com.stuffvish.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_layout.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayGround();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four Game");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {

        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        Menu helpMenu = new Menu("Help");

        MenuItem aboutConnect4 = new MenuItem("What is Connect4");
        aboutConnect4.setOnAction(actionEvent -> aboutConnect4());

        MenuItem howToPlay = new MenuItem("How to Play");
        howToPlay.setOnAction(actionEvent -> howToPlay());           //Lambda Function

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About the maker");
        aboutMe.setOnAction(new EventHandler<ActionEvent>() {          //Without Lambda Function
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutMe();
            }
        });

        helpMenu.getItems().addAll(aboutConnect4, howToPlay, separatorMenuItem1, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Maker");
        alert.setHeaderText("Vishal Pandey");
        alert.setContentText("I love to play around with code and create games. " +
                "Connect$ is one of them. In free time I like to spend time " +
                "with nears and dears. ");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4 Game");
        alert.setHeaderText("Basic Information and Origin of the Game");
        alert.setContentText("Connect-Four is a tic-tac-toe-like two-player game in which players alternately place" +
                " pieces on a vertical board 7 columns across and 6 rows high. Each player uses pieces of a particular" +
                " color (commonly black and red, or sometimes yellow and red), and the object is to be the first to " +
                "obtain four pieces in a horizontal, vertical, or diagonal line. Because the board is vertical, pieces" +
                " inserted in a given column always drop to the lowest unoccupied row of that column. As soon as a " +
                "column contains 6 pieces, it is full and no other piece can be placed in the column.");
        alert.show();
    }

    private void howToPlay(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How to play");
        alert.setHeaderText("How to Play Connect4");
        alert.setContentText("First, decide who goes first and what color each player will have. \n" +
                "Players must alternate turns, and only one disc can be dropped in each turn. \n" +
                "On your turn, drop one of your colored discs from the top into any of the seven slots. \n" +
                "The game ends when there is a 4-in-a-row or a stalemate.\n" +
                "The starter of the previous game goes second on the next game.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        //TODO
    }
}
