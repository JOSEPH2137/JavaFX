package com.example.javafx.Level;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VueLevel1 extends VBox {
    Button beginButton = new Button("Commencer level 1. \n Tu as appris un nouveau sort : \n Wingardium Leviosa. \n C'est le nombre 1.");
    Button spell = new Button("lancer le sort");
    TextField spellNumber = new TextField("entre le numéro du sort");
    Button escapeButton = new Button("échappe toi");
    Button fightButton = new Button("se battre à main nue");


    Label textetest = new Label("");
    Label playerpv = new Label("Tes pv");
    Label trollpv = new Label("Troll pv");
    Button next = new Button("next");
    Label message = new Label("");











    public VueLevel1(){
        beginButton.getStyleClass().add("btn");
        beginButton.setPrefSize(250, 100);
        spell.getStyleClass().add("btn");
        spellNumber.getStyleClass().add("textfield");
        escapeButton.getStyleClass().add("btn");
        fightButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");
        playerpv.getStyleClass().add("label");
        playerpv.setTextFill(Color.WHITE);
        trollpv.getStyleClass().add("label");
        trollpv.setTextFill(Color.WHITE);
        next.getStyleClass().add("btn");
        message.getStyleClass().add("label");
        message.setTextFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));


        Image backgroundImage = new Image(getClass().getResource("/00d1a09be73ceb2d0abe346c387bdd0f.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 5, 0);
        gridPane.add(spell, 0, 10);
        gridPane.add(spellNumber, 0, 11);
        gridPane.add(escapeButton, 1, 3);
        gridPane.add(fightButton, 10, 8);
        gridPane.add(textetest, 5, 3);
        gridPane.add(playerpv, 0, 20);
        gridPane.add(trollpv, 15, 20);
        gridPane.add(next, 8, 22);
        gridPane.add(message, 8, 10);




        this.getChildren().addAll(stackPane);
    }

}