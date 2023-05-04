package com.example.javafx.Level;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

public class VueLevel2 extends VBox{
    Button beginButton = new Button("begin level 2");
    Label textetest = new Label("");


    public VueLevel2(){
        beginButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");



        this.getChildren().addAll(beginButton,textetest);
    }


}
