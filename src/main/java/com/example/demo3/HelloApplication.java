package com.example.demo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        GridPane ControlPanel = new GridPane();
        GridPane RollPanel = new GridPane();
        Button Startbtn = new Button("START");
        Button Endbtn = new Button("KONIEC");
        TextField Rollamountfield = new TextField();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Startbtn.setText("JESZCZE RAZ");
                ArrayList RollArray = new ArrayList<>();
                HashMap ScoreArray = new HashMap();
                int Rollamount = Integer.parseInt(Rollamountfield.getText());
                RollArray.clear();
                RollPanel.getChildren().clear();
                System.out.println(RollPanel.getChildren());
                for (int i = 0; i < Rollamount; i++) {
                    GridPane Dice = new GridPane();
                    RollPanel.add(Dice,0, i + 1);
                    Dice.setStyle("-fx-border-style: solid inside;");
                    Dice.setStyle("-fx-border-color: black;");
                    Dice.setPadding(new Insets(10, 15, 15, 10));
                    for (int j = 0; j < Math.random() * 6; j++) {
                        Button b = new Button();
                        b.setDisable(true);
                        int row = 0;
                        if (j > 2) row = 1;
                        Dice.add(b, j - (3 * row), row);
                    }
                    RollArray.add(Dice.getChildren().size());
                }
                RollArray.sort(null);
                for (int i = 0; i < RollArray.size(); i++) {
                }
            }
        };

        Startbtn.setOnAction(event);

        /*for (int i = 0; i < 10; i++) {
            Button b1 = new Button();
            gridPane.add(b1, i + 4, i);
        }*/


        gridPane.add(ControlPanel,0,0);
        gridPane.add(RollPanel,0,1);

        RollPanel.setVgap(5);

        ControlPanel.setHgap(15);
        ControlPanel.setVgap(5);
        ControlPanel.add(Startbtn, 1, 1);
        ControlPanel.add(Endbtn, 2, 1);
        ControlPanel.add(Rollamountfield, 3, 1);

        ControlPanel.setStyle("-fx-border-style: solid inside;");
        ControlPanel.setStyle("-fx-border-color: black;");
        ControlPanel.setPadding(new Insets(10, 15, 15, 0));

        Scene scene = new Scene(gridPane, 640, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}