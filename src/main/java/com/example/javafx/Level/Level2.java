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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Level2 {
    private VueLevel2 startVue;
    private Player player;
    private boolean play;


    private Boss basilic;
    private Boss jedusorBook;



    public Level2(VueLevel2 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.beginButton.setOnAction(this::begin);
        startVue.spell.setOnAction(this::spell);
        startVue.waitButton.setOnAction(this::wait);
        startVue.fightButton.setOnAction(this::fight);
        startVue.next.setOnAction(this::next);
        boolean play=false;

        Boss basilic = new Boss( 100, 20);
        this.basilic=basilic;
        Boss jedusorBook = new Boss (1,0);
        this.jedusorBook=jedusorBook;
        Spell accio = new Spell(60,1,"2");
        if (player.knownSpell.size()<2) {
            player.knownSpell.add(accio);
        }
        if (player.house==3){
            accio.precision=accio.precision+25;
        }


    }




    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);
        startVue.playerpv.setText("Tes pv : "+player.pv);
        startVue.trollpv.setText("Troll pv : "+basilic.pv);
    }

    public void spell (ActionEvent e){
        if(play==true){
            Random random = new Random();
            boolean findSpell = false;
            String text = startVue.spellNumber.getText();
            for (Spell spell : player.knownSpell) {
                if (spell.number.equals(text)) {
                    findSpell = true;
                    if ("1".equals(text)){
                        player.pv = player.pv - basilic.attack;
                        startVue.message.setText("Ce sort est inutile");
                    }
                    else {
                        int attack = spell.attack;
                        int precision = spell.precision;
                        int pres = random.nextInt(100 - 1) + 1;
                        if (pres < precision) {
                            jedusorBook.pv = jedusorBook.pv - attack;
                            startVue.message.setText("Tu arraches une dent au basilik,\n puis tu détruis le carnet de Jedusor.");
                        } else {
                            player.pv = player.pv - basilic.attack;
                            startVue.message.setText("Tu as raté le sort");
                        }
                    }
                }
            }
            if (findSpell == false) {
                player.pv = player.pv - basilic.attack;
                startVue.message.setText("Tu ne connais pas ce sort");
            }
            if (player.pv<1){
                player.pv=0;
            }
            startVue.playerpv.setText("Tes pv : "+player.pv);
            startVue.trollpv.setText("Basilic pv : "+basilic.pv);
            if (player.pv<1){
                startVue.spell.setDisable(true);
                startVue.fightButton.setDisable(true);
                startVue.waitButton.setDisable(true);
            }
            else if(jedusorBook.pv<1) {
                startVue.spell.setDisable(true);
                startVue.fightButton.setDisable(true);
                startVue.waitButton.setDisable(true);
            }

        }
    }
    public void wait (ActionEvent e){
        startVue.message.setText("Rien ne se passe");
        if (play==true){
            if (player.house==1) {
                startVue.message.setText("Le phoenix te donne l'épée de \nGryffindor, et tu tues le basilisk.");
                startVue.spell.setDisable(true);
                startVue.fightButton.setDisable(true);
                startVue.waitButton.setDisable(true);
                basilic.pv=0;
                startVue.trollpv.setText("Basilic pv : "+basilic.pv);

        }

        }
    }
    public void fight (ActionEvent e){
        if(play==true){
            player.pv = 0;
            startVue.playerpv.setText("Tes pv : "+player.pv);
            startVue.trollpv.setText("Basilic pv : "+basilic.pv);
            startVue.message.setText("Le basilik te tue");
            if (player.pv<1){
                startVue.spell.setDisable(true);
                startVue.fightButton.setDisable(true);
                startVue.waitButton.setDisable(true);
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
        } else if (jedusorBook.pv < 1) {
            player.level = 3;
            VueMakePotion newVue = new VueMakePotion();
            MakePotion newController = new MakePotion(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (basilic.pv < 1) {
            player.level = 3;
            VueMakePotion newVue = new VueMakePotion();
            MakePotion newController = new MakePotion(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }


    }
}
