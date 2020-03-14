package com.math.time;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainFx.fxml"));
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Total Time");
        primaryStage.setScene(new Scene(root, 255, 325));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
