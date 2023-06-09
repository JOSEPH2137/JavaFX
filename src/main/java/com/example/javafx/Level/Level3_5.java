package com.example.javafx.Level;


import com.example.javafx.CreateObject.Boss;
import com.example.javafx.CreateObject.Player;
import com.example.javafx.CreateObject.Potion;
import com.example.javafx.CreateObject.Spell;
import com.example.javafx.general.Loose;
import com.example.javafx.general.MakePotion;
import com.example.javafx.general.VueMakePotion;
import com.example.javafx.general.Vueloose;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Level3_5 {
    private VueLevel3_5 startVue;
    private Player player;
    private boolean play;


    private Boss detractor;



    public Level3_5(VueLevel3_5 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);
        startVue.spell.setOnAction(this::spell);
        startVue.escapeButton.setOnAction(this::escape);
        startVue.negociateButton.setOnAction(this::fight);
        startVue.next.setOnAction(this::next);
        boolean play=false;
        Boss detractor = new Boss( 100, 20);
        this.detractor=detractor;

    }




    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);
        startVue.playerpv.setText("Tes pv : "+player.pv);
        startVue.detraqueurpv.setText("Detraqueur pv : "+detractor.pv);
    }

    public void spell (ActionEvent e) {
        if (play == true) {
            Random random = new Random();
            boolean findSpell = false;
            String text = startVue.spellNumber.getText();
            for (Spell spell : player.knownSpell) {
                if (spell.number.equals(text)) {
                    findSpell = true;
                    if ("1".equals(text)) {
                        player.pv = player.pv - detractor.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("2".equals(text)) {
                        player.pv = player.pv - detractor.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else {
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            detractor.pv = detractor.pv - attack;
                            startVue.message.setText("Tu as touché le detraqueur");
                        } else {
                            player.pv = player.pv - detractor.attack;
                            startVue.message.setText("Tu as raté le détraqueur");
                        }

                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - detractor.attack;
                startVue.message.setText("Tu ne connais pas ce sort");
            }
            if (player.pv<1){
                player.pv=0;
            }
            if (detractor.pv<1){
                detractor.pv=0;
            }
            startVue.playerpv.setText("Tes pv : " + player.pv);
            startVue.detraqueurpv.setText("Detraqueur pv : " + detractor.pv);
            if (player.pv < 1) {
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
            } else if (detractor.pv < 1) {
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
            }

        }
    }

    public void escape (ActionEvent e){
        if(play==true){
            player.pv = 0;
            startVue.playerpv.setText("Tes pv : "+player.pv);
            startVue.detraqueurpv.setText("Detraqueur pv : "+detractor.pv);
            startVue.message.setText("Le detraqueur t'a tué");
            if (player.pv<1){
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
            }
        }
    }
    public void fight (ActionEvent e){
        if(play==true){
            player.pv = 0;
            startVue.playerpv.setText("Tes pv : "+player.pv);
            startVue.detraqueurpv.setText("Detractor pv : "+detractor.pv);
            startVue.message.setText("Le detraqueur t'a tué");
            if (player.pv<1){
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
            }
        }
    }
    public void next (ActionEvent e) {
        if (player.pv < 1) {
            Vueloose newVue = new Vueloose();
            Loose newController = new Loose(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        } else if (detractor.pv < 1) {
            player.level = 4;
            VueMakePotion newVue = new VueMakePotion();
            MakePotion newController = new MakePotion(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }
}