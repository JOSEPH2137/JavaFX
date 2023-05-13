package com.example.javafx.general;

import com.example.javafx.CreateObject.Player;
import com.example.javafx.Level.VueLevel2;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

public class Loose {
    private Vueloose startVue;
    private Player player;
    public Loose(Vueloose startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);

    }
    public void begin (ActionEvent e){

        startVue.textetest.setText("Sorry, I don't code this option yet");

    }
}
