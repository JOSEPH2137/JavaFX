package com.example.javafx.Level;

import com.example.javafx.CreateObject.Boss;
import com.example.javafx.CreateObject.Player;
import com.example.javafx.general.Loose;
import com.example.javafx.general.MakePotion;
import com.example.javafx.general.VueMakePotion;
import com.example.javafx.general.Vueloose;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Level5 {
    private VueLevel5 startVue;
    private Player player;
    private boolean play;
    private int paperplanetime;
    private int askquestiontime;

    private Boss doloresOmbrage;
    public Level5(VueLevel5 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        boolean play=false;

        Boss doloresOmbrage = new Boss( 50, 30);
        this.doloresOmbrage=doloresOmbrage;
        int paperplanetime = 0;
        int askquestiontime = 0;

        startVue.beginButton.setOnAction(this::begin);
        startVue.plane.setOnAction(this::plane);
        startVue.ask.setOnAction(this::ask);
        startVue.nothing.setOnAction(this::nothing);
        startVue.spell.setOnAction(this::spell);
        startVue.complimente.setOnAction(this::complimente);
        startVue.next.setOnAction(this::next);

    }
    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);
        startVue.time.setText("Temps restant : "+doloresOmbrage.pv);
        startVue.anger.setText("% de colère de Dolorès : "+doloresOmbrage.attack);
    }
    public void plane (ActionEvent e){
        paperplanetime=paperplanetime+1;
        if (paperplanetime>2){
            player.pv=0;
            startVue.spell.setDisable(true);
            startVue.ask.setDisable(true);
            startVue.plane.setDisable(true);
            startVue.complimente.setDisable(true);
            startVue.nothing.setDisable(true);
            startVue.message.setText("Dolores t'a vu. Tu es puni.");
        }
        else{
            doloresOmbrage.attack=doloresOmbrage.attack + 20;
            if (doloresOmbrage.attack>99) {
                startVue.spell.setDisable(true);
                startVue.ask.setDisable(true);
                startVue.plane.setDisable(true);
                startVue.complimente.setDisable(true);
                startVue.nothing.setDisable(true);
            }
            doloresOmbrage.pv=doloresOmbrage.pv -10;
            if (doloresOmbrage.pv<1) {
                startVue.spell.setDisable(true);
                startVue.ask.setDisable(true);
                startVue.plane.setDisable(true);
                startVue.complimente.setDisable(true);
                startVue.nothing.setDisable(true);
            }
            if (doloresOmbrage.attack>100){
                doloresOmbrage.attack=100;
            }
            if (doloresOmbrage.pv<0){
                doloresOmbrage.pv=0;
            }
            startVue.time.setText("Temps restant : "+doloresOmbrage.pv);
            startVue.anger.setText("% de colère de Dolorès : "+doloresOmbrage.attack);
            startVue.message.setText("Dolorès ne sait pas qui envoie l'avion");
        }

    }
    public void ask (ActionEvent e){
        askquestiontime=askquestiontime +1;
        if (askquestiontime>2){
            player.pv=0;
            startVue.spell.setDisable(true);
            startVue.ask.setDisable(true);
            startVue.plane.setDisable(true);
            startVue.complimente.setDisable(true);
            startVue.nothing.setDisable(true);
            startVue.message.setText("Tu poses trop de questions. Tu es puni.");
        }
        else{
            doloresOmbrage.attack=doloresOmbrage.attack + 25;
            if (doloresOmbrage.attack>99) {
                startVue.spell.setDisable(true);
                startVue.ask.setDisable(true);
                startVue.plane.setDisable(true);
                startVue.complimente.setDisable(true);
                startVue.nothing.setDisable(true);
            }
            doloresOmbrage.pv=doloresOmbrage.pv -10;
            if (doloresOmbrage.pv<1) {
                startVue.spell.setDisable(true);
                startVue.ask.setDisable(true);
                startVue.plane.setDisable(true);
                startVue.complimente.setDisable(true);
                startVue.nothing.setDisable(true);
            }
            if (doloresOmbrage.attack>100){
                doloresOmbrage.attack=100;
            }
            if (doloresOmbrage.pv<0){
                doloresOmbrage.pv=0;
            }
            startVue.time.setText("Temps restant : "+doloresOmbrage.pv);
            startVue.anger.setText("% de colère de Dolorès : "+doloresOmbrage.attack);
            startVue.message.setText("tu énerves Dolorès avec tes questions");
        }

    }
    public void nothing (ActionEvent e){
        player.pv=0;
        startVue.spell.setDisable(true);
        startVue.ask.setDisable(true);
        startVue.plane.setDisable(true);
        startVue.complimente.setDisable(true);
        startVue.nothing.setDisable(true);
        startVue.message.setText("Tu n'as pas réussi à distraire Dolores");

    }
    public void spell (ActionEvent e){
        startVue.message.setText("Tu n'as pas de baguette sur toi.");
    }
    public void complimente (ActionEvent e){
        doloresOmbrage.attack=doloresOmbrage.attack-10;
        doloresOmbrage.pv=doloresOmbrage.pv -3;
        if (doloresOmbrage.attack<0){
            doloresOmbrage.attack=0;
        }
        if (doloresOmbrage.pv<0){
            doloresOmbrage.pv=0;
        }
        if (doloresOmbrage.pv<1) {
            startVue.spell.setDisable(true);
            startVue.ask.setDisable(true);
            startVue.plane.setDisable(true);
            startVue.complimente.setDisable(true);
            startVue.nothing.setDisable(true);
        }
        startVue.time.setText("Temps restant : "+doloresOmbrage.pv);
        startVue.anger.setText("% de colère de Dolorès : "+doloresOmbrage.attack);
        startVue.message.setText("le compliment fait plaisir à Dolores.");

    }
    public void next (ActionEvent e){
        if (player.pv<1){
            Vueloose newVue = new Vueloose();
            Loose newController = new Loose(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if(doloresOmbrage.pv<1) {
            player.level=6;
            VueMakePotion newVue = new VueMakePotion();
            MakePotion newController = new MakePotion(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }
}