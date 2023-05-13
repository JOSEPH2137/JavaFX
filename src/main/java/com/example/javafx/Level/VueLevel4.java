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

public class VueLevel4 extends VBox {
    Button beginButton = new Button("begin level 4");
    Button spell = new Button("cast the spell");
    TextField spellNumber = new TextField("enter the spell's number");
    Button escapeButton = new Button("escape you");
    Button negociateButton = new Button("negociate with voldemort");
    Button next = new Button("next");
    Label message = new Label("");



    public VueLevel4(){
        beginButton.getStyleClass().add("btn");
        spell.getStyleClass().add("btn");
        spellNumber.getStyleClass().add("textfield");
        escapeButton.getStyleClass().add("btn");
        negociateButton.getStyleClass().add("btn");
        next.getStyleClass().add("btn");
        message.getStyleClass().add("label");
        message.setTextFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));


        Image backgroundImage = new Image(getClass().getResource("/021dd7590c8f06055a9c7228b9cfffba--harry-potter-voldemort-lord-voldemort.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 5, 0);
        beginButton.setPrefSize(250, 100);
        gridPane.add(spell, 0, 10);
        gridPane.add(spellNumber, 0, 11);
        gridPane.add(escapeButton, 1, 3);
        gridPane.add(negociateButton, 10, 8);
        gridPane.add(next, 8, 22);
        gridPane.add(message, 8, 10);


        this.getChildren().addAll(stackPane);
    }

}
