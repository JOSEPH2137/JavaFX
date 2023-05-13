package com.example.javafx.Level;

import com.example.javafx.CreateObject.Player;
import com.example.javafx.CreateObject.Spell;
import com.example.javafx.general.MakePotion;
import com.example.javafx.general.VueMakePotion;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Level3 {
    private VueLevel3 startVue;
    private Player player;
    private boolean play;
    private boolean play3;
    private long startTime;
    private long stopTime;
    private int button;
    private int attack;
    public Level3(VueLevel3 startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        play=false;
        play3=false;
        startVue.beginButton.setOnAction(this::begin);
        startVue.one.setOnAction(this::number1);
        startVue.two.setOnAction(this::number2);
        startVue.three.setOnAction(this::number3);
        startVue.four.setOnAction(this::number4);
        startVue.five.setOnAction(this::number5);
        startVue.six.setOnAction(this::number6);
        startVue.seven.setOnAction(this::number7);
        startVue.eight.setOnAction(this::number8);
        startVue.nine.setOnAction(this::number9);
        startVue.ten.setOnAction(this::number10);
        startVue.fightlevel3.setOnAction(this::fightlevel3);


    }
    public void begin (ActionEvent e){
        play=true;
        ((Pane) startVue.beginButton.getParent()).getChildren().remove(startVue.beginButton);
        startTime = System.currentTimeMillis();
        button=0;
    }
    public void number1 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.one.getParent()).getChildren().remove(startVue.one);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number2 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.two.getParent()).getChildren().remove(startVue.two);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number3 (ActionEvent e) {
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.three.getParent()).getChildren().remove(startVue.three);
            if (button == 10) {
                patronus();
            }
        }


    }
    public void number4 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.four.getParent()).getChildren().remove(startVue.four);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number5 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.five.getParent()).getChildren().remove(startVue.five);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number6 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.six.getParent()).getChildren().remove(startVue.six);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number7 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.seven.getParent()).getChildren().remove(startVue.seven);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number8 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.eight.getParent()).getChildren().remove(startVue.eight);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number9 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.nine.getParent()).getChildren().remove(startVue.nine);
            if (button == 10) {
                patronus();
            }
        }

    }
    public void number10 (ActionEvent e){
        if ( play==true) {
            button = button + 1;
            ((Pane) startVue.ten.getParent()).getChildren().remove(startVue.ten);
            if (button == 10) {
                patronus();

            }
        }

    }
    public void patronus() {
        stopTime= System.currentTimeMillis();
        long time =stopTime-startTime;
        if (time < 7000) {

            attack = 100;
            startVue.textetest.setText("Your patronum is an unicorn. You time was :"+time/1000+" secondes");

        } else if (time < 10000) {

            attack = 80;
            startVue.textetest.setText("Your patronum is a deer. You time was :"+time/1000+" secondes");

        } else if (time < 15000) {

            attack = 60;
            startVue.textetest.setText("Your patronum is an colt). You time was :"+time/1000+" secondes");

        } else {
            attack = 50;
            startVue.textetest.setText("Your patronum is a nutria. You time was :"+time/1000+" secondes");

        }
        Spell expectoPatronum = new Spell(80, attack, "3");
        player.knownSpell.add(expectoPatronum);
        if (player.house == 3) {
            expectoPatronum.precision = expectoPatronum.precision + 10;
        } else if (player.house == 2) {
            expectoPatronum.attack = expectoPatronum.attack + 20;
        }
        play3=true;

    }
    public void fightlevel3 (ActionEvent e){
        if (play3==true) {
            VueLevel3_5 newVue = new VueLevel3_5();
            Level3_5 newController = new Level3_5(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
    }
}
