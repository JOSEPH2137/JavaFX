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
    Button beginButton = new Button("begin level 1");
    Button spell = new Button("spell");
    TextField spellNumber = new TextField("enter the spell");
    Button escapeButton = new Button("escape you");
    Button fightButton = new Button("fight with your hands");


    Label textetest = new Label("");
    Label playerpv = new Label("player pv");
    Label trollpv = new Label("Troll pv");









    public VueLevel1(){
        beginButton.getStyleClass().add("btn");
        spell.getStyleClass().add("btn");
        spellNumber.getStyleClass().add("textfield");
        escapeButton.getStyleClass().add("btn");
        fightButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");
        playerpv.getStyleClass().add("label");
        playerpv.setTextFill(Color.WHITE);
        trollpv.getStyleClass().add("label");
        trollpv.setTextFill(Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image("file:C:/Users/joseph/IdeaProjects/JavaFX/src/main/resources/00d1a09be73ceb2d0abe346c387bdd0f.jpg");
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 10, 0);
        gridPane.add(spell, 0, 10);
        gridPane.add(spellNumber, 0, 11);
        gridPane.add(escapeButton, 1, 3);
        gridPane.add(fightButton, 10, 8);
        gridPane.add(textetest, 5, 3);
        gridPane.add(playerpv, 0, 20);
        gridPane.add(trollpv, 15, 20);




        this.getChildren().addAll(stackPane);
    }

}