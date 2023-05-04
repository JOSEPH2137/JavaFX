package com.example.javafx.Level;


import com.example.javafx.CreateObject.Boss;
import com.example.javafx.CreateObject.Player;
import com.example.javafx.CreateObject.Potion;
import com.example.javafx.CreateObject.Spell;
import com.example.javafx.general.Loose;
import com.example.javafx.general.Vueloose;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Level1 {
    private VueLevel1 startVue;
    private Player player;
    private boolean play;

    private Boss troll;



    public Level1(VueLevel1 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);
        startVue.spell.setOnAction(this::spell);
        startVue.escapeButton.setOnAction(this::escape);
        startVue.fightButton.setOnAction(this::fight);
        boolean play=false;
        Boss troll = new Boss( 100, 20);
        this.troll=troll;
        Spell wingardiumLeviosa = new Spell(75,40,"1");
        Potion lifePotion= new Potion(1);
        if (player.knownSpell.size()<1) {
            player.knownSpell.add(wingardiumLeviosa);
        }
        if (player.knownPotion.size()<1) {
            player.knownPotion.add(lifePotion);
        }

        if (player.house==3){
            wingardiumLeviosa.precision=wingardiumLeviosa.precision+20;
        }
        else if (player.house==2){
            wingardiumLeviosa.attack=wingardiumLeviosa.attack+10;
        }
        else if (player.house==1){
            troll.attack=troll.attack-5;
        }

    }




    public void begin (ActionEvent e){
        play=true;
        startVue.playerpv.setText("Your pv : "+player.pv);
        startVue.trollpv.setText("Troll pv : "+troll.pv);
    }
    public void spell (ActionEvent e){
        if(play==true){
            Random random = new Random();
            boolean findSpell = false;
            String text = startVue.spellNumber.getText();
            for (Spell spell : player.knownSpell) {
                if (spell.number.equals(text)) {
                    findSpell = true;
                    int attack = spell.attack;
                    int precision = spell.precision;
                    int pres = random.nextInt(100 - 1) + 1;
                    if (pres < precision) {
                        troll.pv = troll.pv - attack;
                    } else {
                        player.pv = player.pv - troll.attack;
                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - troll.attack;
            }
            startVue.playerpv.setText("Your pv : "+player.pv);
            startVue.trollpv.setText("Troll pv : "+troll.pv);
            if (player.pv<1){
                Vueloose newVue = new Vueloose();
                Loose newController = new Loose(newVue, player);
                Scene newScene = new Scene(newVue, 800, 600);
                Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                currentStage.setScene(newScene);
            }
            else if(troll.pv<1) {
                VueLevel2 newVue = new VueLevel2();
                Level2 newController = new Level2(newVue, player);
                Scene newScene = new Scene(newVue, 800, 600);
                Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                currentStage.setScene(newScene);
            }

        }
    }
    public void escape (ActionEvent e){
        if(play==true){
            player.pv = 0;
            startVue.playerpv.setText("Your pv : "+player.pv);
            startVue.trollpv.setText("Troll pv : "+troll.pv);
            if (player.pv<1){
                Vueloose newVue = new Vueloose();
                Loose newController = new Loose(newVue, player);
                Scene newScene = new Scene(newVue, 800, 600);
                Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                currentStage.setScene(newScene);
            }
        }
    }
    public void fight (ActionEvent e){
        if(play==true){
            player.pv = player.pv - 50;
            troll.pv = troll.pv + 1;
            startVue.playerpv.setText("Your pv : "+player.pv);
            startVue.trollpv.setText("Troll pv : "+troll.pv);
            if (player.pv<1){
                Vueloose newVue = new Vueloose();
                Loose newController = new Loose(newVue, player);
                Scene newScene = new Scene(newVue, 800, 600);
                Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                currentStage.setScene(newScene);
            }
        }
    }



}