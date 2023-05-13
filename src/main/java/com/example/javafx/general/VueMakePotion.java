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

public class VueMakePotion extends VBox{
    Button yes = new Button("work and make a life potion");
    Button no = new Button("just chill");



    public VueMakePotion(){
        yes.getStyleClass().add("btn");
        no.getStyleClass().add("btn");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image("file:C:/Users/joseph/IdeaProjects/JavaFX/src/main/resources/creepy-alchemist-lab-d-render-renderowanie-laboratorium-alchemika-albo-wiedźma-wypełnione-ziołami-magicznymi-składnikami-170108623.jpg");
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(yes, 0, 0);
        gridPane.add(no, 0, 10);


        this.getChildren().addAll(stackPane);


    }


}
