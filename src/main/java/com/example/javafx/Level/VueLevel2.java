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

public class VueLevel2 extends VBox{
    Button beginButton = new Button("Commencer le level 2. \n Tu as appris un nouveau sort : \n accio. \n C'est le nombre 2.");
    Button spell = new Button("lancer le sort");
    TextField spellNumber = new TextField("entre le numéro de sort");
    Button waitButton = new Button("attendre quelques secondes");
    Button fightButton = new Button("se battre à main nue");


    Label textetest = new Label("");
    Label playerpv = new Label("Tes pv");
    Label basilicpv = new Label("Basilic pv");
    Button next = new Button("next");
    Label message = new Label("");









    public VueLevel2(){
        beginButton.getStyleClass().add("btn");
        beginButton.setPrefSize(250, 100);
        spell.getStyleClass().add("btn");
        spellNumber.getStyleClass().add("textfield");
        waitButton.getStyleClass().add("btn");
        fightButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");
        playerpv.getStyleClass().add("label");
        playerpv.setTextFill(Color.WHITE);
        basilicpv.getStyleClass().add("label");
        basilicpv.setTextFill(Color.WHITE);
        next.getStyleClass().add("btn");
        message.getStyleClass().add("label");
        message.setTextFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image(getClass().getResource("/927565da783126765b7a96406661adb1--harry-potter-book-covers-harry-potter-books.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 5, 0);
        gridPane.add(spell, 0, 10);
        gridPane.add(spellNumber, 0, 11);
        gridPane.add(waitButton, 1, 3);
        gridPane.add(fightButton, 10, 8);
        gridPane.add(textetest, 5, 3);
        gridPane.add(playerpv, 0, 20);
        gridPane.add(basilicpv, 15, 20);
        gridPane.add(next, 8, 22);
        gridPane.add(message, 6, 10,5,3);




        this.getChildren().addAll(stackPane);
    }


}
