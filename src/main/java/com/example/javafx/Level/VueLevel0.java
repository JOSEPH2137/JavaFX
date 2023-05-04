package com.example.javafx.Level;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
public class VueLevel0 extends VBox {
    Label welcomeText = new Label("Welcome to wizards world");
    Button finishButton = new Button("finish");
    TextField inputField = new TextField("enter your name");
    Button findWand = new Button("find your wand");
    Label wandText = new Label("");
    Button findHouse = new Button("find your house");
    Label houseText = new Label("Your house is ");
    Button pet1 = new Button("Cat");
    Button pet2 = new Button("Toad");
    Button pet3 = new Button("Rat");
    Button pet4 = new Button("Howl");
    Label petText = new Label("Your animal is a");





    public VueLevel0(){
        welcomeText.getStyleClass().add("label");
        welcomeText.setTextFill(Color.WHITE);
        inputField.getStyleClass().add("textfield");
        houseText.getStyleClass().add("label");
        houseText.setTextFill(Color.WHITE);
        wandText.getStyleClass().add("label");
        wandText.setTextFill(Color.WHITE);
        finishButton.getStyleClass().add("btn");
        findWand.getStyleClass().add("btn");
        findHouse.getStyleClass().add("btn");
        pet1.getStyleClass().add("btn");
        pet2.getStyleClass().add("btn");
        pet3.getStyleClass().add("btn");
        pet4.getStyleClass().add("btn");
        petText.getStyleClass().add("label");
        petText.setTextFill(Color.WHITE);





        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image("file:C:/Users/joseph/IdeaProjects/JavaFX/src/main/resources/thumb-1920-84314.jpg");
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);


        gridPane.add(welcomeText, 0, 0, 3, 1);
        gridPane.add(inputField, 0, 1, 3, 1);
        gridPane.add(findWand, 1, 2);
        gridPane.add(wandText, 1, 3,4,1);
        gridPane.add(findHouse, 5, 2);
        gridPane.add(houseText, 5, 3);
        gridPane.add(pet1, 1, 4);
        gridPane.add(pet2, 2, 4);
        gridPane.add(pet3, 3, 4);
        gridPane.add(pet4, 4, 4);
        gridPane.add(petText, 0, 5, 3, 1);
        gridPane.add(finishButton, 3, 6, 3, 1);

        this.getChildren().add(stackPane);
    }

}