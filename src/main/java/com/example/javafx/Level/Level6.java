package com.example.javafx.Level;

import com.example.javafx.CreateObject.Boss;
import com.example.javafx.CreateObject.Player;
import com.example.javafx.CreateObject.Spell;
import com.example.javafx.general.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Level6 {
    private VueLevel6 startVue;
    private Player player;
    private boolean play;

    private Boss mangemort1;
    private Boss mangemort2;
    public Level6(VueLevel6 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);
        startVue.escapeButton.setOnAction(this::negociate);
        startVue.next.setOnAction(this::next);
        startVue.mangemort1action.setOnAction(this::mangemort1action);
        startVue.mangemort2action.setOnAction(this::mangemort2action);
        Spell spectumsempra = new Spell(75,100,"4");
        if (player.knownSpell.size() < 4) {
            player.knownSpell.add(spectumsempra);
        }
        Boss mangemort1 = new Boss( 250, 10);
        this.mangemort1=mangemort1;
        Boss mangemort2 = new Boss( 200, 20);
        this.mangemort2=mangemort2;
        if (player.house==3){
            spectumsempra.precision=spectumsempra.precision+20;
        }
        else if (player.house==2){
            spectumsempra.attack=spectumsempra.attack+50;
        }
        else if (player.house==1){
            mangemort1.attack=mangemort1.attack-5;
            mangemort2.attack=mangemort2.attack-5;
        }

    }
    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);
        startVue.playerpv.setText("Tes pv : "+player.pv);
        startVue.mangemort1pv.setText("mangemort1 pv : "+mangemort1.pv);
        startVue.mangemort2pv.setText("mangemort2 pv : "+mangemort2.pv);
    }
    public void mangemort1action (ActionEvent e) {
        if (play == true) {
            Random random = new Random();
            boolean findSpell = false;
            String text = startVue.spellNumber.getText();
            for (Spell spell : player.knownSpell) {
                if (spell.number.equals(text)) {
                    findSpell = true;
                    if ("1".equals(text)) {
                        player.pv = player.pv - mangemort1.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("2".equals(text)) {
                        player.pv = player.pv - mangemort1.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("3".equals(text)) {
                        player.pv = player.pv - mangemort1.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else {
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            mangemort1.pv = mangemort1.pv - attack;
                            if (mangemort2.pv>1) {
                                player.pv = player.pv - mangemort2.attack;
                            }
                            startVue.message.setText("Tu as touché le mangemort");
                        } else {
                            player.pv = player.pv - mangemort1.attack;
                            startVue.message.setText("Tu as raté le mangemort");
                        }

                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - mangemort1.attack;
                startVue.message.setText("Tu ne connais pas ce sort");
            }
            if (player.pv < 1) {
                player.pv = 0;
            }
            if (mangemort1.pv < 1) {
                mangemort1.pv = 0;
            }
            startVue.playerpv.setText("Tes pv : " + player.pv);
            startVue.mangemort1pv.setText("mangemort1 pv : " + mangemort1.pv);
            startVue.mangemort2pv.setText("mangemort2 pv : " + mangemort2.pv);
            if (player.pv < 1) {
                startVue.mangemort1action.setDisable(true);
                startVue.mangemort2action.setDisable(true);
                startVue.escapeButton.setDisable(true);
            } else if (mangemort1.pv < 1) {
                startVue.mangemort1action.setDisable(true);
                if (mangemort2.pv<1) {
                    startVue.escapeButton.setDisable(true);
                }
            }
        }
    }
    public void mangemort2action (ActionEvent e) {
        if (play == true) {
            Random random = new Random();
            boolean findSpell = false;
            String text = startVue.spellNumber.getText();
            for (Spell spell : player.knownSpell) {
                if (spell.number.equals(text)) {
                    findSpell = true;
                    if ("1".equals(text)) {
                        player.pv = player.pv - mangemort2.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("2".equals(text)) {
                        player.pv = player.pv - mangemort2.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("3".equals(text)) {
                        player.pv = player.pv - mangemort2.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else {
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            mangemort2.pv = mangemort2.pv - attack;
                            if (mangemort1.pv>1) {
                                player.pv = player.pv - mangemort1.attack;
                            }
                            startVue.message.setText("Tu as touché le mangemort");
                        } else {
                            player.pv = player.pv - mangemort2.attack;
                            startVue.message.setText("Tu as raté le mangemort");
                        }

                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - mangemort2.attack;
                startVue.message.setText("Tu ne connais pas ce sort");
            }
            if (player.pv < 1) {
                player.pv = 0;
            }
            if (mangemort2.pv < 1) {
                mangemort2.pv = 0;
            }
            startVue.playerpv.setText("Tes pv : " + player.pv);
            startVue.mangemort1pv.setText("mangemort1 pv : " + mangemort1.pv);
            startVue.mangemort2pv.setText("mangemort2 pv : " + mangemort2.pv);
            if (player.pv < 1) {
                startVue.mangemort2action.setDisable(true);
                startVue.mangemort1action.setDisable(true);
                startVue.escapeButton.setDisable(true);
            } else if (mangemort2.pv < 1) {
                startVue.mangemort2action.setDisable(true);
                if (mangemort1.pv<1) {
                    startVue.escapeButton.setDisable(true);
                }
            }
        }
    }


    public void negociate(ActionEvent e){
        if (player.house==2){
            startVue.message.setText("Comme tu es à Serpentard,\n ils t'acceptent");
            player.pv=1000;
            startVue.mangemort1action.setDisable(true);
            startVue.mangemort2action.setDisable(true);
            startVue.escapeButton.setDisable(true);
        }
        else{
            startVue.message.setText("un des magemorts te tue\n d'un avada kedavra");
            player.pv=0;
            startVue.mangemort1action.setDisable(true);
            startVue.mangemort2action.setDisable(true);
            startVue.escapeButton.setDisable(true);
        }
    }
    public void next (ActionEvent e){
        if (player.pv>999){
            VueStrangeEnd newVue = new VueStrangeEnd();
            StrangeEnd newController = new StrangeEnd(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (player.pv<1){
            Vueloose newVue = new Vueloose();
            Loose newController = new Loose(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if(mangemort1.pv<1 & mangemort2.pv<1) {
            player.level=7;
            VueMakePotion newVue = new VueMakePotion();
            MakePotion newController = new MakePotion(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }
}