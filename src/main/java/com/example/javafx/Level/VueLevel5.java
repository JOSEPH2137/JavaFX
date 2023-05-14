package com.example.javafx.Level;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VueLevel5 extends VBox {
    Button beginButton = new Button("Commencer le level 5 \n Tu dois distraire dolores ombrage \npendant suffisemment de temps pour  \nque tes amis préparent un feu d'artifice");
    Button plane = new Button("lancer un avion en papier");
    Button ask = new Button("poser une question");
    Button nothing = new Button("ne rien faire");
    Button spell = new Button("lancer un sort");
    Button complimente = new Button("faire un compliment");
    Label time = new Label("");
    Label anger = new Label("");
    Button next = new Button("next");
    Label message = new Label("");


    public VueLevel5(){
        beginButton.getStyleClass().add("btn");
        beginButton.setPrefSize(250, 100);
        plane.getStyleClass().add("btn");
        ask.getStyleClass().add("btn");
        nothing.getStyleClass().add("btn");
        spell.getStyleClass().add("btn");
        complimente.getStyleClass().add("btn");
        next.getStyleClass().add("btn");
        time.getStyleClass().add("label");
        time.setTextFill(Color.WHITE);
        anger.getStyleClass().add("label");
        anger.setTextFill(Color.WHITE);
        message.getStyleClass().add("label");
        message.setTextFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));


        Image backgroundImage = new Image(getClass().getResource("/4649e986ac7d31c25926d532c3f29a33.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 5, 0);
        gridPane.add(plane, 0, 11);
        gridPane.add(ask, 0,15 );
        gridPane.add(nothing, 15, 11);
        gridPane.add(spell, 7,13 );
        gridPane.add(complimente, 15,15 );
        gridPane.add(time, 0, 20);
        gridPane.add(anger, 15, 20);
        gridPane.add(next, 8, 22);
        gridPane.add(message, 8, 10);

        this.getChildren().addAll(stackPane);
    }

}
