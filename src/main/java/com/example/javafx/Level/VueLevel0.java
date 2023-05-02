package com.example.javafx.Level;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class VueLevel0 extends VBox {
    Label welcomeText = new Label("Welcome to wizards world");
    Button finishButton = new Button("finish");
    TextField inputField = new TextField("enter your name");
    Button findWand = new Button("find your wand");
    Label wand = new Label("");
    Button findHouse = new Button("find your house");
    Label house = new Label("Your house is ");
    Button pet1 = new Button("Cat");
    Button pet2 = new Button("Toad");
    Button pet3 = new Button("Rat");
    Button pet4 = new Button("Howl");
    Label petText = new Label("Your animal is a");





    public VueLevel0(){
        welcomeText.getStyleClass().add("label");

        inputField.getStyleClass().add("textfield");
        house.getStyleClass().add("label");
        wand.getStyleClass().add("label");
        finishButton.getStyleClass().add("btn");
        findWand.getStyleClass().add("btn");
        findHouse.getStyleClass().add("btn");
        pet1.getStyleClass().add("btn");
        pet2.getStyleClass().add("btn");
        pet3.getStyleClass().add("btn");
        pet4.getStyleClass().add("btn");
        petText.getStyleClass().add("label");

        this.getChildren().addAll(welcomeText, inputField,finishButton,findWand,wand,findHouse,house,pet1,pet2,pet3,pet4, petText);
    }

}