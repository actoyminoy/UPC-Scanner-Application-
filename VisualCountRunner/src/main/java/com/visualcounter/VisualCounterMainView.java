package com.visualcounter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VisualCounterMainView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VisualCounterMainView.class.getResource("TryHard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 360);
        stage.setTitle("UPC Counter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}