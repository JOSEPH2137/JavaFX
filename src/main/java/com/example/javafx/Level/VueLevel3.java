package com.example.javafx.Level;

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

public class VueLevel3 extends VBox {
    Button beginButton = new Button("begin level 3. \n You must learn a new spell : \n Expecto Patronum. \n It is the number 3.");
    Label textetest = new Label("Appuye sur tout les boutons pour montrer ta dextérité");

    Button one=new Button ("");
    Button two=new Button ("");
    Button three=new Button ("");
    Button four=new Button ("");
    Button five=new Button ("");
    Button six=new Button ("");
    Button seven=new Button ("");
    Button eight=new Button ("");
    Button nine=new Button ("");
    Button ten=new Button ("");

    Button fightlevel3=new Button ("next");


    public VueLevel3(){
        beginButton.getStyleClass().add("btn");
        beginButton.setPrefSize(250, 100);
        one.getStyleClass().add("btn");
        two.getStyleClass().add("btn");
        three.getStyleClass().add("btn");
        four.getStyleClass().add("btn");
        five.getStyleClass().add("btn");
        six.getStyleClass().add("btn");
        seven.getStyleClass().add("btn");
        eight.getStyleClass().add("btn");
        nine.getStyleClass().add("btn");
        ten.getStyleClass().add("btn");
        fightlevel3.getStyleClass().add("btn");

        textetest.getStyleClass().add("label");
        textetest.setTextFill(Color.WHITE);


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        Image backgroundImage = new Image(getClass().getResource("/43edd01683e7105b6aceb12675362d43.jpg").toString());
        Rectangle background = new Rectangle(5, 5, 800, 600);
        background.setFill(new ImagePattern(backgroundImage));
        StackPane stackPane = new StackPane(background, gridPane);
        stackPane.setAlignment(Pos.CENTER);

        gridPane.add(beginButton, 5, 0);
        gridPane.add(one,13 ,11 );
        gridPane.add(two, 12,4 );
        gridPane.add(three, 2, 8);
        gridPane.add(four,18 ,7 );
        gridPane.add(five,2 , 4);
        gridPane.add(six,1 ,7 );
        gridPane.add(seven, 13,1 );
        gridPane.add(eight,19 ,12 );
        gridPane.add(nine,15 , 2);
        gridPane.add(ten,2 , 17);
        gridPane.add(fightlevel3,7, 20);

        gridPane.add(textetest, 5, 3);



        this.getChildren().addAll(stackPane);
    }

}