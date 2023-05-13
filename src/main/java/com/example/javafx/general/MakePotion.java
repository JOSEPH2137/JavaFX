package com.example.javafx.general;

import com.example.javafx.CreateObject.Player;
import com.example.javafx.Level.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MakePotion {
    private VueMakePotion startVue;
    private Player player;
    public MakePotion(VueMakePotion startVue, Player player) {
        this.startVue = startVue;
        this.player= player;
        startVue.yes.setOnAction(this::yes);
        startVue.no.setOnAction(this::no);


    }
    public void yes (ActionEvent e){
        player.pv=player.pv +20;
        if (player.house==4){
            player.pv=player.pv+20;
        }
        if (player.level==2){
            VueLevel2 newVue = new VueLevel2();
            Level2 newController = new Level2(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (player.level==3){
            VueLevel3 newVue = new VueLevel3();
            Level3 newController = new Level3(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (player.level==4){
            VueLevel4 newVue = new VueLevel4();
            Level4 newController = new Level4(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (player.level==5){
            VueLevel5 newVue = new VueLevel5();
            Level5 newController = new Level5(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (player.level==6){
            VueLevel6 newVue = new VueLevel6();
            Level6 newController = new Level6(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        else if (player.level==7){
            VueLevel7 newVue = new VueLevel7();
            Level7 newController = new Level7(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }



    }
    public void no (ActionEvent e){
        if (player.level==2){
            VueLevel2 newVue = new VueLevel2();
            Level2 newController = new Level2(newVue, player);
            Scene newScene = new Scene(newVue, 800, 600);
            Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }

    }


}

