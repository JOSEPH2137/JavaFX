package com.example.javafx.Level;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VueLevel1 extends VBox {
    Button beginButton = new Button("begin");
    Label textetest = new Label("abracadabra");









    public VueLevel1(){
        beginButton.getStyleClass().add("btn");
        textetest.getStyleClass().add("label");



        this.getChildren().addAll(beginButton,textetest);
    }

}