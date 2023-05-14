package com.example.javafx.general;

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

public class VueVictory extends VBox {
    Label textetest = new Label("Bravo tu as gagné le jeu");


    public VueVictory(){

        textetest.getStyleClass().add("label");
        textetest.setTextFill(Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));


        Image backgroundImage = new Image(getClass().getResource("/thumb-victoire-4k-wallpapers-with-names-female-names-victoire-name.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(textetest, 8, 22);

        this.getChildren().addAll(stackPane);
    }

}




