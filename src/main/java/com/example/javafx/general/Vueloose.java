package com.example.javafx.general;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Vueloose extends VBox{
    Button beginButton = new Button("begin again");
    Label textetest = new Label("Tu as perdu");


    public Vueloose(){
        beginButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image("file:C:/Users/joseph/IdeaProjects/JavaFX/src/main/resources/maxresdefault.jpg");
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 0, 15, 3, 1);
        gridPane.add(textetest, 0, 0, 3, 1);



        this.getChildren().addAll(stackPane);
    }


}
