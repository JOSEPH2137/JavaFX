package com.example.javafx;

import com.example.javafx.Level.Level0;
import com.example.javafx.Level.Level1;
import com.example.javafx.Level.VueLevel0;
import com.example.javafx.Level.VueLevel1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VueLevel0 startVue = new VueLevel0();
        Level0 startController = new Level0(startVue);
        Scene scene = new Scene(startVue, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}