package com.example.javafx.Level;

import com.example.javafx.CreateObject.Boss;
import com.example.javafx.CreateObject.Player;
import com.example.javafx.CreateObject.Spell;
import com.example.javafx.general.Loose;
import com.example.javafx.general.MakePotion;
import com.example.javafx.general.VueMakePotion;
import com.example.javafx.general.Vueloose;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Level4 {
    private VueLevel4 startVue;
    private Player player;
    private boolean play;
    private boolean castspell;
    private boolean direction;

    private boolean runportauloin;
    private Boss voldemort;
    public Level4(VueLevel4 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);
        startVue.spell.setOnAction(this::spell);
        startVue.escapeButton.setOnAction(this::escape);
        startVue.negociateButton.setOnAction(this::negociate);
        startVue.next.setOnAction(this::next);
        boolean play=false;
        boolean castspell=false;
        boolean direction=false;
        boolean runportauloin=false;
        Boss voldemort = new Boss( 1, 1);
        this.voldemort=voldemort;

    }
    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);

    }

    public void spell (ActionEvent e) {
        if (play == true) {
            if (castspell == true) {
                Random random = new Random();
                boolean findSpell = false;
                String text = startVue.spellNumber.getText();
                for (Spell spell : player.knownSpell) {
                    if (spell.number.equals(text)) {
                        findSpell = true;
                        if ("1".equals(text)) {
                            startVue.message.setText("Ce sort est inutile, Voldemort t'a tué");
                            player.pv = 0;
                            startVue.spell.setDisable(true);
                            startVue.negociateButton.setDisable(true);
                            startVue.escapeButton.setDisable(true);
                        } else if ("3".equals(text)) {
                            startVue.message.setText("Ce sort est inutile, Voldemort t'a tué");
                            player.pv = 0;
                            startVue.spell.setDisable(true);
                            startVue.negociateButton.setDisable(true);
                            startVue.escapeButton.setDisable(true);
                        } else {
                            int precision = spell.precision+30;
                            int pres = random.nextInt(100 - 1) + 1;
                            if (pres < precision) {
                                startVue.message.setText("tu attrapes le portauloin, et t'échappes.");
                                voldemort.pv = 0;
                                startVue.spell.setDisable(true);
                                startVue.negociateButton.setDisable(true);
                                startVue.escapeButton.setDisable(true);
                            } else {

                                startVue.message.setText("Tu rates le sort et Voldemort te tue");
                                player.pv = 0;
                                startVue.spell.setDisable(true);
                                startVue.negociateButton.setDisable(true);
                                startVue.escapeButton.setDisable(true);
                            }

                        }
                    }
                }
                if (findSpell == false) {
                    startVue.message.setText("Voldemort te tue car tu ne connais pas ce sort");
                    player.pv = 0;
                    startVue.spell.setDisable(true);
                    startVue.negociateButton.setDisable(true);
                    startVue.escapeButton.setDisable(true);
                }
            }
            else{
                player.pv = 0;
                startVue.message.setText("Voldemort te tue avant que tu lances le sort");
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
            }
        }
    }
    public void negociate (ActionEvent e){
        if(play==true){
            if (direction==false) {
                player.pv = 0;
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
                startVue.message.setText("Voldemort te tue.");
            }
            else{
                player.pv = 0;
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
                startVue.message.setText("Voldemort te tue pendant que tu cours.");

            }
        }
    }
    public void escape (ActionEvent e){
        if(play==true) {
            if (direction==false) {
                startVue.escapeButton.setText("s'échapper à droite");
                startVue.negociateButton.setText("s'échapper à gauche");
                direction=true;
            }
            else if(runportauloin==true){
                player.pv = 0;
                startVue.spell.setDisable(true);
                startVue.negociateButton.setDisable(true);
                startVue.escapeButton.setDisable(true);
                startVue.message.setText("Voldemort te tue pendant que tu cours.");

            }
            else{
                castspell=true;
                startVue.message.setText("Tu vois le portauloin à cinq mètres.");
                startVue.escapeButton.setText("courir vers le portauloin");
                runportauloin=true;
                startVue.negociateButton.setDisable(true);
            }
        }

    }
    public void next (ActionEvent e){
        if (player.pv<1){
            Vueloose newVue = new Vueloose();
            Loose newController = new Loose(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if(voldemort.pv<1) {
            player.level=5;
            VueMakePotion newVue = new VueMakePotion();
            MakePotion newController = new MakePotion(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }
}