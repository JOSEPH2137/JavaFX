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
    Label welcomeText = new Label("Bienvenue dans le monde des sorciers");
    Button finishButton = new Button("next");
    TextField inputField = new TextField("entre ton nom");
    Button findWand = new Button("trouve ta baguette");
    Label wandText = new Label("");
    Button findHouse = new Button("trouve ta maison");
    Label houseText = new Label("Ta maison est ");
    Button pet1 = new Button("Chat");
    Button pet2 = new Button("Crapaud");
    Button pet3 = new Button("Rat");
    Button pet4 = new Button("Chouette");
    Label petText = new Label("Ton animal est un");

    Label instruction = new Label("Bonjour, Voici quelques éléments pour que votre aventure se déroule pour le mieux :\n- Lorsque vous envoyez un sort il faut d'abord entrer le numéro correspondant au sort. \nPour cela vous avez une zone de texte sous le bouton -cast a spell-. \n par exemple pour lancer le sort Wingardium leviosa, vous devrez d'abord écrir 1 dans la zone de texte \n puis appuyer sur le bouton Wingardium Leviosa.\n -pour commencer un niveau, il faut appuyer sur le gros bouton en haut \n -Pour passer au niveau suivant, il faut appuyer sur le petit bouton next en bas");





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
        instruction.getStyleClass().add("label");
        instruction.setTextFill(Color.WHITE);





        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image(getClass().getResource("/thumb-1920-84314.jpg").toString());
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
        gridPane.add(instruction, 0, 8, 8, 5);

        this.getChildren().add(stackPane);
    }

}