package com.example.javafx.Level;

import com.example.javafx.CreateObject.Player;
import com.example.javafx.CreateObject.Potion;
import com.example.javafx.CreateObject.Spell;
import com.example.javafx.CreateObject.Wand;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level0 {
    private VueLevel0 startVue;
    private Stage stage;
    public Player player;
    private Wand wand;
    public Level0(VueLevel0 startVue){
        this.startVue = startVue;
        wand = new Wand(0, 0);
        int pv = 100;
        List<Spell> knownSpell = new ArrayList();
        List<Potion> knownPotion = new ArrayList();
        player = new Player(pv,"", wand, 0, 0,knownSpell,knownPotion);

        startVue.finishButton.setOnAction(this::finish);
        startVue.findHouse.setOnAction(this::House );
        startVue.findWand.setOnAction(this::Wand);
        startVue.pet1.setOnAction(this::pet1);
        startVue.pet2.setOnAction(this::pet2);
        startVue.pet3.setOnAction(this::pet3);
        startVue.pet4.setOnAction(this::pet4);

    }
    public void finish (ActionEvent e) {
        if (player.house!=0&&player.wand.sizeWand!=0&&player.pet!=0){
            String text = startVue.inputField.getText();
            player.playerName = text;
            VueLevel1 newVue = new VueLevel1();
            Level1 newController = new Level1(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }






    public void House (ActionEvent e){
        ((Button)e.getSource()).setDisable(true);
        Random random = new Random();
        int house = random.nextInt(4 - 0) + 1;
        if (house == 1) {
            startVue.houseText.setText("Your house is Griffondor");
            player.house=house;
        } else if (house == 2) {
            startVue.houseText.setText("Your house is Serpentard");
            player.house=house;
        } else if (house == 3) {
            startVue.houseText.setText("Your house is Serdaigle");
            player.house=house;
        } else {
            startVue.houseText.setText("Your house is Poustouffle");
            player.house=house;
        }
    }
    public void Wand (ActionEvent e){
        ((Button)e.getSource()).setDisable(true);
        Random random = new Random();
        int coreWand = random.nextInt(3 - 0) + 1;
        int sizeWand = random.nextInt(12 - 0) + 20;
        if (coreWand == 1) {
            startVue.wandText.setText("You have a wand with an unicorn hair! It measures "+sizeWand + " cm");
            wand.sizeWand=sizeWand;
            wand.coreWand=coreWand;
        } else if (coreWand == 2) {
            startVue.wandText.setText("You have a wand with a phoenix feather! It measures "+sizeWand + " cm");
            wand.sizeWand=sizeWand;
            wand.coreWand=coreWand;
        } else {
            startVue.wandText.setText("You have a wand with a dragon ventricle! It measures "+sizeWand + " cm");
            wand.sizeWand=sizeWand;
            wand.coreWand=coreWand;
        }
        player.wand=wand;


    }
    public void pet1 (ActionEvent e){
        player.pet=1;
        startVue.petText.setText("Your animal is a cat");
    }
    public void pet2 (ActionEvent e){
        player.pet=2;
        startVue.petText.setText("Your animal is a toad");
    }
    public void pet3 (ActionEvent e){
        player.pet=3;
        startVue.petText.setText("Your animal is a rat");
    }
    public void pet4 (ActionEvent e){
        player.pet=4;
        startVue.petText.setText("Your animal is a howl");
    }


}
