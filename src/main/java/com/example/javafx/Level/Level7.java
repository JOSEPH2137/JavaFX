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

public class Level7 {
    private VueLevel7 startVue;
    private Player player;
    private boolean play;

    private Boss bellatrix;
    private Boss voldemort;
    public Level7(VueLevel7 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);
        startVue.escapeButton.setOnAction(this::negociate);
        startVue.next.setOnAction(this::next);
        startVue.mangemort1action.setOnAction(this::mangemort1action);
        startVue.mangemort2action.setOnAction(this::mangemort2action);
        Spell expelliarmus = new Spell(40, 0, "5");
        if (player.knownSpell.size() < 5){
            player.knownSpell.add(expelliarmus);
        }
        Boss bellatrix = new Boss(200, 25);
        this.bellatrix=bellatrix;
        Boss voldemort = new Boss(300, 50);
        this.voldemort=voldemort;
        if (player.house == 3) {
            expelliarmus.precision = expelliarmus.precision + 25;
        } else if (player.house == 2) {
            expelliarmus.attack = expelliarmus.attack + 50;
        } else if (player.house == 1) {
            bellatrix.attack = bellatrix.attack - 10;
            voldemort.attack = voldemort.attack - 10;
        }

    }
    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);
        startVue.playerpv.setText("Tes pv : "+player.pv);
        startVue.mangemort1pv.setText("Voldemort pv : "+voldemort.pv);
        startVue.mangemort2pv.setText("Bellatrix pv : "+bellatrix.pv);
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
                        player.pv = player.pv - voldemort.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("2".equals(text)) {
                        player.pv = player.pv - voldemort.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("3".equals(text)) {
                        player.pv = player.pv - voldemort.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if("4".equals(text)){
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            voldemort.pv = voldemort.pv - attack;
                            if (bellatrix.pv>1) {
                                player.pv = player.pv - bellatrix.attack;
                            }
                            startVue.message.setText("Tu as touché Voldemort");
                        } else {
                            player.pv = player.pv - voldemort.attack;
                            startVue.message.setText("Tu as raté Voldemort");
                        }

                    }
                    else{
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            voldemort.attack=0;
                            if (bellatrix.pv>1) {
                                player.pv = player.pv - bellatrix.attack;
                            }
                            startVue.message.setText("Voldemort est désarmé");
                        } else {
                            player.pv = player.pv - voldemort.attack;
                            startVue.message.setText("Tu as raté Voldemort");
                        }

                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - voldemort.attack;
                startVue.message.setText("Tu ne connais pas ce sort");
            }
            if (player.pv < 1) {
                player.pv = 0;
            }
            if (voldemort.pv < 1) {
                voldemort.pv = 0;
            }
            startVue.playerpv.setText("Tes pv : " + player.pv);
            startVue.mangemort1pv.setText("voldemort pv : " + voldemort.pv);
            startVue.mangemort2pv.setText("bellatrix pv : " + bellatrix.pv);
            if (player.pv < 1) {
                startVue.mangemort1action.setDisable(true);
                startVue.mangemort2action.setDisable(true);
                startVue.escapeButton.setDisable(true);
            } else if (voldemort.pv < 1) {
                startVue.mangemort1action.setDisable(true);
                if (bellatrix.pv<1) {
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
                        player.pv = player.pv - bellatrix.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("2".equals(text)) {
                        player.pv = player.pv - bellatrix.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("3".equals(text)) {
                        player.pv = player.pv - bellatrix.attack;
                        startVue.message.setText("Ce sort est inutile");
                    } else if ("4".equals(text)){
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            bellatrix.pv = bellatrix.pv - attack;
                            if (voldemort.pv>1) {
                                player.pv = player.pv - voldemort.attack;
                            }
                            startVue.message.setText("Tu as touché Bellatrix");
                        } else {
                            player.pv = player.pv - bellatrix.attack;
                            startVue.message.setText("Tu as raté Bellatrix");
                        }

                    }
                    else{
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            bellatrix.attack=0;
                            if (voldemort.pv>1) {
                                player.pv = player.pv - voldemort.attack;
                            }
                            startVue.message.setText("Bellatrix est désarmé");
                        } else {
                            player.pv = player.pv - voldemort.attack;
                            startVue.message.setText("Tu as raté Bellatrix");
                        }


                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - bellatrix.attack;
                startVue.message.setText("Tu ne connais pas ce sort");
            }
            if (player.pv < 1) {
                player.pv = 0;
            }
            if (bellatrix.pv < 1) {
                bellatrix.pv = 0;
            }
            startVue.playerpv.setText("Tes pv : " + player.pv);
            startVue.mangemort1pv.setText("mangemort1 pv : " + voldemort.pv);
            startVue.mangemort2pv.setText("mangemort2 pv : " + bellatrix.pv);
            if (player.pv < 1) {
                startVue.mangemort2action.setDisable(true);
                startVue.mangemort1action.setDisable(true);
                startVue.escapeButton.setDisable(true);
            } else if (bellatrix.pv < 1) {
                startVue.mangemort2action.setDisable(true);
                if (voldemort.pv<1) {
                    startVue.escapeButton.setDisable(true);
                }
            }
        }
    }


    public void negociate(ActionEvent e){
        startVue.message.setText("Voldemort et Bellatrix te lancent \nun double Avada Kedavra\n Tu as réalisé l'exploit de \nmourir deux fois.");
        player.pv=0;
        startVue.mangemort1action.setDisable(true);
        startVue.mangemort2action.setDisable(true);
        startVue.escapeButton.setDisable(true);
    }
    public void next (ActionEvent e){
        if (player.pv<1){
            Vueloose newVue = new Vueloose();
            Loose newController = new Loose(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if(voldemort.pv<1 & bellatrix.pv<1) {
            VueVictory newVue = new VueVictory();
            Victory newController = new Victory(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }
}