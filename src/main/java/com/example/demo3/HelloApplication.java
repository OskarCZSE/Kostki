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
import javafx.scene.text.Text;
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
        Text FinalValText = new Text("Finalna wartość to: ");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Startbtn.setText("JESZCZE RAZ");
                FinalValText.setText("Finalna wartość to: ");
                ArrayList RollArray = new ArrayList<>();
                ArrayList ScoreArray = new ArrayList<>();
                ArrayList HelpArray = new ArrayList<>();
                int Rollamount = Integer.parseInt(Rollamountfield.getText());
                int FinalValue = 0;
                RollArray.clear();
                ScoreArray.clear();
                HelpArray.clear();
                RollPanel.getChildren().clear();
                for (int i = 0; i < Rollamount; i++) {
                    GridPane Dice = new GridPane();
                    int i2 = i / 5;
                    RollPanel.add(Dice, i2, i + 1 - (i2 * 5));
                    Dice.setStyle("-fx-border-style: solid inside;");
                    Dice.setStyle("-fx-border-color: black;");
                    Dice.setPadding(new Insets(10, 15, 15, 10));
                    for (int j = 0; j < Math.random() * 6; j++) {
                        Button b = new Button();
                        b.setDisable(true);
                        int row = 0;
                        row = j % 2;
                        Dice.add(b, j - row, row);
                        Dice.setMaxWidth(75);
                        Dice.setMinWidth(75);
                        Dice.setMinHeight(78);
                        Dice.setMaxWidth(78);
                    }
                    RollArray.add(Dice.getChildren().size());
                }
                RollArray.sort(null);
                for (int i = 0; i < RollArray.size(); i++) {
                    if (HelpArray.contains(RollArray.get(i))) {
                        if (!ScoreArray.contains(RollArray.get(i))) ScoreArray.add(RollArray.get(i));
                        ScoreArray.add(RollArray.get(i));
                    }
                    HelpArray.add(RollArray.get(i));
                }
                for (var score : ScoreArray){
                    FinalValue += (int)score;
                }
                FinalValText.setText(FinalValText.getText() + FinalValue);
            }
        };

        EventHandler<ActionEvent> endevent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        };

        Startbtn.setOnAction(event);
        Endbtn.setOnAction(endevent);
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
        ControlPanel.add(FinalValText, 4, 1);

        ControlPanel.setStyle("-fx-border-style: solid inside;");
        ControlPanel.setStyle("-fx-border-color: black;");
        ControlPanel.setPadding(new Insets(10, 15, 15, 0));
        ControlPanel.setMinWidth(500);
        ControlPanel.setMaxWidth(500);

        Scene scene = new Scene(gridPane, 640, 480);
        stage.setTitle("Kostki!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}