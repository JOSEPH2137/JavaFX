package com.example.javafx.Level;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

public class VueLevel5 extends VBox {
    Button beginButton = new Button("begin level 1");
    Label textetest = new Label("");


    public VueLevel5(){
        beginButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");

        this.getChildren().addAll(beginButton,textetest);
    }

}
