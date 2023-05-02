package com.example.javafx.Level;


import com.example.javafx.CreateObject.Player;
import javafx.event.ActionEvent;

public class Level1 {
    private VueLevel1 startVue;
    private Player player;


    public Level1(VueLevel1 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);


    }
    public void begin (ActionEvent e){
        startVue.textetest.setText(player.playerName);
    }



}