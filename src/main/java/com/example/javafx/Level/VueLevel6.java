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

public class VueLevel6 extends VBox {
    Button beginButton = new Button("Commencer level 6. \n Tu as appris un nouveau sort : \n spectumsempra \n C'est le nombre 4.");
    TextField spellNumber = new TextField("entre le numéro du sort");
    Button escapeButton = new Button("demander à les rejoindre");
    Button mangemort1action = new Button("lancer le sort sur mangemort1");
    Button mangemort2action = new Button("lancer le sort sur mangemort2");

    Label playerpv = new Label("Tes pv");
    Label mangemort1pv = new Label("Mangemort1 pv");
    Label mangemort2pv = new Label("Mangemort2 pv");
    Button next = new Button("next");
    Label message = new Label("");











    public VueLevel6(){
        beginButton.getStyleClass().add("btn");
        beginButton.setPrefSize(250, 100);
        spellNumber.getStyleClass().add("textfield");
        escapeButton.getStyleClass().add("btn");
        mangemort1action.getStyleClass().add("btn");
        mangemort2action.getStyleClass().add("btn");
        playerpv.getStyleClass().add("label");
        playerpv.setTextFill(Color.WHITE);
        mangemort1pv.getStyleClass().add("label");
        mangemort1pv.setTextFill(Color.WHITE);
        mangemort2pv.getStyleClass().add("label");
        mangemort2pv.setTextFill(Color.WHITE);
        next.getStyleClass().add("btn");
        message.getStyleClass().add("label");
        message.setTextFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));


        Image backgroundImage = new Image(getClass().getResource("/0079c131bf057fb80a8774eb49b029ff.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 5, 0);
        gridPane.add(spellNumber, 0, 11);
        gridPane.add(escapeButton, 10, 8);
        gridPane.add(playerpv, 0, 20);
        gridPane.add(mangemort1pv, 15, 20);
        gridPane.add(mangemort1action, 0, 9);
        gridPane.add(mangemort2pv, 15, 22);
        gridPane.add(mangemort2action, 0, 10);
        gridPane.add(next, 8, 22);
        gridPane.add(message, 8, 10);




        this.getChildren().addAll(stackPane);
    }

}

